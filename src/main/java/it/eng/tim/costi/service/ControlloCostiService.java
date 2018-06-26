package it.eng.tim.costi.service;

import static it.eng.tim.costi.util.FormatterUtils.formatCurrency;
//import static it.eng.tim.costi.util.FormatterUtils.formatCurrency;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import it.eng.tim.costi.integration.proxy.SDPProxy;
import it.eng.tim.costi.model.configuration.ServiceConstants;
import it.eng.tim.costi.model.domain.ServiceRequest;
import it.eng.tim.costi.model.exception.ServiceException;
import it.eng.tim.costi.model.integration.sdp.gateSender.Category;
import it.eng.tim.costi.model.integration.sdp.gateSender.GateSenderAggregatiCostiResponse;
import it.eng.tim.costi.model.integration.sdp.gateSender.GateSenderConstants;
import it.eng.tim.costi.model.integration.sdp.npat.CommonData;
import it.eng.tim.costi.model.integration.sdp.npat.NPATConstants;
import it.eng.tim.costi.model.integration.sdp.npat.QueryGroup;
import it.eng.tim.costi.model.integration.sdp.npat.QueryRiepilogoCostiBean;
import it.eng.tim.costi.model.integration.sdp.npat.StatisticheTrafficoTOTResponse;
import it.eng.tim.costi.model.integration.sdp.npat.TipologieTrafficoTOTBean;
import it.eng.tim.costi.model.web.AggregatoCostiResponse;
import it.eng.tim.costi.model.web.MoreInfo;
import it.eng.tim.costi.model.web.Movement;
import it.eng.tim.costi.model.web.Section;
import it.eng.tim.costi.util.DateRange;
import it.eng.tim.costi.util.DateUtils;
import it.eng.tim.costi.util.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ControlloCostiService {

    private SDPProxy sdpProxy;


    private static final Random __random = new Random();
    
    @Autowired
    public ControlloCostiService(SDPProxy sdpProxy) {
        this.sdpProxy = sdpProxy;
       
        
    }


    
    
    public AggregatoCostiResponse getControlloCostiAggregato(ServiceRequest serviceReq, HttpHeaders headers) throws ServiceException{
    	
    	boolean npatInfo = false;
    	boolean gsInfo = false;
    	
    	AggregatoCostiResponse response = new AggregatoCostiResponse();
    	List<Section> sectionList = new ArrayList<Section>();
    	List<Movement> movList1 = new ArrayList<Movement>();
    	List<Movement> movList2 = new ArrayList<Movement>();
    	
    	response.setSections(sectionList);

    	Section section1 = new Section();
    	section1.setOrder(1);
    	section1.setLabel("Movimenti su credito residuo");
    	section1.setMovements(movList1);
    	
    	Section section2 = new Section();
    	section2.setOrder(2);
    	section2.setMovements(movList2);
    	section2.setLabel("Altri addebiti");
    	
    	sectionList.add(section1);
    	sectionList.add(section2);
    	Collections.sort(sectionList);
    	
    	
		String period = serviceReq.getPeriod();
		log.debug("period: " + period);
		DateRange range = DateUtils.getDateRange(period);
    	
		response.setStartDate(range.getStartPresentationDate());
		response.setEndDate(range.getEndPresentationDate());
    	
    	try {
    		//Consumi (Traffico) NPAT
    		
    		QueryRiepilogoCostiBean requestBean = buildQueryFullForNPAT(range);
    		
    		StatisticheTrafficoTOTResponse npatResponse = sdpProxy.getStatisticheTrafficoTOT(serviceReq.getFiscalCode(), serviceReq.getMsisdn(), requestBean, headers);
    		
    		Movement traffic = parseNPATResponse(npatResponse);
    		movList1.add(traffic);
    		
    		npatInfo = true;
    		

    	}
    	catch(Exception ex) {
    		log.error("Error in getControlloCostiAggregato " + ExceptionUtil.getStackTrace(ex));
    		
    		throw new ServiceException("Temporary Error", "ERR001");	
    	}
    	
    	try {
    		//Costi (Ricariche/Rinnovi/Altro) GateSender
    		
    		
    		QueryRiepilogoCostiBean requestBean = buildQueryFullForNPAT(range);
    		
    		GateSenderAggregatiCostiResponse gateSenderResponse = sdpProxy.getAggregatiCosti(serviceReq.getFiscalCode(), serviceReq.getMsisdn(), 
    									GateSenderConstants.OP_CODE_AGGREGATO, GateSenderConstants.CLIENT_TYPE, period, headers); 
    				
    		parseGateSenderResponse(gateSenderResponse, movList1, movList2);
    		
    		gsInfo = true;
    		
    		response.setStatus("OK");
    		/*
    		if(npatInfo) {
    			response.setStatus("OK");	
    		}
    		else {
    			response.setStatus("OK"); //OK PARZIALE?
    		}
    		*/
    		return response;
    	}
    	catch(Exception ex) {
    		
    		if(npatInfo) {//ho almeno le info di NPAT
        		response.setStatus("OK"); //OK PARZIALE?
        		return response;
    		}
    		
    		
    		log.error("Error in getControlloCostiAggregato " + ExceptionUtil.getStackTrace(ex));
    		throw new ServiceException("Temporary Error", "ERR001");	
    	}
    	
    	
    }
    
    
    
    
    public Movement parseNPATResponse(StatisticheTrafficoTOTResponse npatResponse) {
    	
    	
    	log.debug("Parsing NPAT Response ["+npatResponse+"]");
		Movement mov = new Movement();
		
		List<MoreInfo> detList = new ArrayList<MoreInfo>();
		mov.setMoreInfo(detList);
		
    	List<TipologieTrafficoTOTBean> trafficList = npatResponse.getStatisticheCostiTOTBean().getTipologieTrafficoTOTBean();
    	
    	log.debug("trafficList.size() = " + trafficList.size());
    	
    	for(int i=0; i< trafficList.size(); i++) {
    	
    		TipologieTrafficoTOTBean current = trafficList.get(i);
    		
    		String tipo = current.getTipo();
    		log.debug("TIPO: " +tipo);
    		
    		if(tipo.equalsIgnoreCase(NPATConstants.TYPE_DATI)) {
    		
    			MoreInfo det = new MoreInfo();
    			double costo = current.getCosto();
    			
        		det.setId("CATDATI");
        		det.setLabel("Dati");
        		det.setValue(getFormattedCost(costo,"-") );
        		det.setDetails("");
        		det.setOrder(2);
        		
        		detList.add(det);
    			
    		}
    		else if(tipo.equalsIgnoreCase(NPATConstants.TYPE_FONIA)) {

    			MoreInfo det = new MoreInfo();
    			double costo = current.getCosto();
    			
        		det.setId("CATVOCE");
        		det.setLabel("Voce");
        		det.setValue(getFormattedCost(costo,"-") );
        		det.setDetails("");
        		det.setOrder(1);

        		detList.add(det);

    		}
    		else if(tipo.equalsIgnoreCase(NPATConstants.TYPE_SMS_MMS)) {
    			MoreInfo det = new MoreInfo();
    			double costo = current.getCosto();
    			
        		det.setId("CATMESS");
        		det.setLabel("SMS/MMS");
        		det.setValue(getFormattedCost(costo,"-") );
        		det.setDetails("");
        		det.setOrder(3);
        		
        		detList.add(det);
    			
    		}
    		else if(tipo.equalsIgnoreCase(NPATConstants.TYPE_TOTALE)) {
    			
    			double costo = current.getCosto();
        		mov.setOrder(3);
        		mov.setId("CATCONS");
        		mov.setLabel("Consumi");
        		mov.setValue(getFormattedCost(costo,"-") );
    		}
    		
    	}//for

    	Collections.sort(mov.getMoreInfo());
    	
    	return mov;
    	
    }
    

    
    public void parseGateSenderResponse(GateSenderAggregatiCostiResponse gateSenderResponse, List<Movement> movList1, List<Movement> movList2) {
    	
    	
    	log.debug("Parsing GateSender Response ["+gateSenderResponse+"]");
    	
    	//List<Movement> movList = response.getMovements();

		List<Category> categoryList = gateSenderResponse.getCategoryList();
    	
    	log.debug("categoryList.size() = " + categoryList.size());
    	
    	for(int i=0; i< categoryList.size(); i++) {
    	
    		Category current = categoryList.get(i);
    		
    		String id = current.getCategoryId();
    		
    		log.debug("id: " +id);
    		
    		if(id.equalsIgnoreCase(GateSenderConstants.CAT01_RICARICHE )) {
    		
    			Movement mov = new Movement();
    			double costo = current.getTotalCost();
        		mov.setOrder(1);
        		mov.setId(id);
        		mov.setLabel("Ricariche");
        		mov.setValue(getFormattedCost(costo,"+") );
        		
        		movList1.add(mov);
    			
    		}
    		else if(id.equalsIgnoreCase(GateSenderConstants.CAT02_ATTIVAZIONI )) {

    			Movement mov = new Movement();
    			double costo = current.getTotalCost();
        		mov.setOrder(2);
        		mov.setId(id);
        		mov.setLabel("Attivazioni e Rinnovi");
        		mov.setValue(getFormattedCost(costo,"-") );
        		
        		movList1.add(mov);

    		}
    		else if(id.equalsIgnoreCase(GateSenderConstants.CAT03_ALTRO )) {

    			Movement mov = new Movement();
    			double costo = current.getTotalCost();
        		mov.setOrder(4);
        		mov.setId(id);
        		mov.setLabel("Altro");
        		mov.setValue(getFormattedCost(costo,"-") );
        		
        		movList1.add(mov);

    		}
    		else if(id.equalsIgnoreCase(GateSenderConstants.CAT04_RATE )) {

    			Movement mov = new Movement();
    			double costo = current.getTotalCost();
        		mov.setOrder(5);
        		mov.setId(id);
        		mov.setLabel("Rate Prodotti");
        		mov.setValue(getFormattedCost(costo,"-") );
        		
        		movList2.add(mov);

    		}
    		else if(id.equalsIgnoreCase(GateSenderConstants.CAT05_RINNOVI )) {

    			Movement mov = new Movement();
    			double costo = current.getTotalCost();
        		mov.setOrder(6);
        		mov.setId(id);
        		mov.setLabel("Rinnovo offerte");
        		mov.setValue(getFormattedCost(costo,"-") );
        		
        		movList2.add(mov);

    		}
    		
    		
    	}//for

    	Collections.sort(movList1);
    	Collections.sort(movList2);
    	
    }
    
    
    
    private String getFormattedCost(double value, String sign) {
    	
    	String formattedCost = sign + " " + value;
    	
    	if(value == 0) {
    		formattedCost = "0.00";
    	}
    	else {
    		formattedCost = sign + " " + formatCurrency(value);
    	}
    	
    	
    	return formattedCost;
    	
    }
    
    
    private QueryRiepilogoCostiBean buildQueryFullForNPAT(DateRange dateRange) {
    	QueryRiepilogoCostiBean request = new QueryRiepilogoCostiBean();
    	
    	CommonData commonData = new CommonData();
    	
    	commonData.setDataInizio(dateRange.getStartNPATDate() );
    	commonData.setDataFine(dateRange.getEndNPATDate() );
    	
    	// ???
    	commonData.setOperatore("OP1");
    	commonData.setSubSys("SUBSYS");
    	
    	request.setCommonData(commonData);
    	
    	QueryGroup queryGroup = QueryGroup.buildAllTrafficQueryGroup();
    	
    	request.setQueryGroup(queryGroup);
    	
    	return request;
    	
    }
    
    
    
    
    private HttpHeaders buildHttpHeaders() {
    	HttpHeaders headers = new HttpHeaders();
		Date now = new Date(System.currentTimeMillis());
    	
    	
    	headers.set("sourceSystem", ServiceConstants.SOURCE_SYS_ID);
    	headers.set("channel", ServiceConstants.CHANNEL_ID_APP);
    	headers.set("interactionDate-Date", getDate(now));
    	headers.set("interactionDate-Time", getTime(now));

    	/*
    	headers.set("sessionID", "session_id_123");
    	headers.set("businessID", "bid_123");
    	headers.set("transactionID", "trans_123");
    	*/
    	//generateID("tid");

    	headers.set("sessionID", generateID("session"));
    	headers.set("businessID", generateID("bid"));
    	headers.set("transactionID", generateID("tid"));

    	return headers;
    }

	private static String getTime(Date d){
		SimpleDateFormat sdfTime = new SimpleDateFormat ( "HH:mm:ss:SSS" );
		return sdfTime.format(d);
	}


	private static String getDate(Date d){
		SimpleDateFormat sdfDate = new SimpleDateFormat ( "yyyy-MM-dd" );
		return sdfDate.format(d);
	}
	
	
	private String generateTid() {
		return generateID("tid");
	}

	
	public static String generateID( final String prefix) {
		
		final StringBuilder buffer = new StringBuilder( prefix );
		buffer.append("_");
		buffer.append( ( __random.nextInt( 99 ) + 1 ) );
		return buffer.toString();
	}	
	
}
