package it.eng.tim.costi.web.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.eng.tim.costi.model.exception.ServiceException;
import it.eng.tim.costi.model.integration.sdp.gateSender.Category;
import it.eng.tim.costi.model.integration.sdp.gateSender.ErrorResponse;
import it.eng.tim.costi.model.integration.sdp.gateSender.GateSenderAggregatiCostiResponse;
import it.eng.tim.costi.model.integration.sdp.npat.NPATConstants;
import it.eng.tim.costi.model.integration.sdp.npat.QueryRiepilogoCostiBean;
import it.eng.tim.costi.model.integration.sdp.npat.ReportRiepilogoCostiCommonDataBean;
import it.eng.tim.costi.model.integration.sdp.npat.StatisticheCostiTOTBean;
import it.eng.tim.costi.model.integration.sdp.npat.StatisticheTrafficoTOTResponse;
import it.eng.tim.costi.model.integration.sdp.npat.TipologieTrafficoTOTBean;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/")
public class MockControlloCostiController {

	
	 @RequestMapping(method = RequestMethod.POST, value = "clienti/{rifCliente}/consistenze/{numLinea}/statisticheTrafficoTOT")
	    StatisticheTrafficoTOTResponse getStatisticheTrafficoTOT(@PathVariable("rifCliente") String rifCliente,
	    		@PathVariable("numLinea") String msisdn,
	    		@RequestBody QueryRiepilogoCostiBean requestBean,
	    		@RequestHeader HttpHeaders headers) throws ServiceException{
		 
		 
		 log.debug("MOCK - getStatisticheTrafficoTOT (clienti/{rifCliente})");
		 log.debug("MOCK - rifCliente = ["+rifCliente+"] - numLinea=["+msisdn+"]");
		 log.debug("MOCK - HttpHeaders = ["+headers+"]");
		 log.debug("MOCK - RequestBody = ["+requestBean+"]");

		 try {
	        	ObjectMapper mapper = new ObjectMapper();
	        	log.info("MOCK - REQUEST FROM CBE AS JSON = ["+mapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestBean)+"]");
		 }
		 catch(Exception ex) {
			 log.error("MOCK REQUEST ERROR " + ex);
		 }
		 
		 
		 StatisticheTrafficoTOTResponse response = new StatisticheTrafficoTOTResponse();
		 StatisticheCostiTOTBean costiBean = new StatisticheCostiTOTBean();
		 
		 List<TipologieTrafficoTOTBean> tipologieList = new ArrayList<TipologieTrafficoTOTBean>();
		 
		 TipologieTrafficoTOTBean totale = new TipologieTrafficoTOTBean();
		 totale.setCosto(6.00);
		 totale.setTipo(NPATConstants.TYPE_TOTALE);
		 tipologieList.add(totale);
		 
		 TipologieTrafficoTOTBean voce = new TipologieTrafficoTOTBean();
		 voce.setCosto(2.00);
		 voce.setTipo(NPATConstants.TYPE_FONIA);
		 tipologieList.add(voce);
		 
		 TipologieTrafficoTOTBean sms = new TipologieTrafficoTOTBean();
		 sms.setCosto(1.00);
		 sms.setTipo(NPATConstants.TYPE_SMS_MMS);
		 tipologieList.add(sms);
		 
		 TipologieTrafficoTOTBean dati = new TipologieTrafficoTOTBean();
		 dati.setCosto(3.00);
		 dati.setTipo(NPATConstants.TYPE_DATI);
		 tipologieList.add(dati);
		 
		 
		 costiBean.setTipologieTrafficoTOTBean(tipologieList);
		 response.setStatisticheCostiTOTBean(costiBean);
		 
		 ReportRiepilogoCostiCommonDataBean commonData = new ReportRiepilogoCostiCommonDataBean();

		 commonData.setCodErr(0);
		 commonData.setMsisdnInterrogato(msisdn);
		 commonData.setSubSys(requestBean.getCommonData().getSubSys());
		 
		 response.setCommonDataType(commonData);
		 
		 
		 try {
	        	ObjectMapper mapper = new ObjectMapper();
	        	log.info("MOCK - RESPONSE AS JSON = ["+mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response)+"]");
		 }
		 catch(Exception ex) {
			 log.error("MOCK ERROR " + ex);
		 }
		 
		 return response;
		 
	 }

	 
	 
	 @RequestMapping(method = RequestMethod.GET, value = "clienti/{rifCliente}/consistenze/{numLinea}/estrattoConto/aggregatiCosti")
	 GateSenderAggregatiCostiResponse getAggregatiCosti(@PathVariable("rifCliente") String rifCliente,
	    		@PathVariable("numLinea") String msisdn,
	    		@RequestParam(value="codiceOperazione") String codiceOperazione,
	    		@RequestParam(value="clientType") String clientType,
	    		@RequestParam(value="profonditaRichiesta") String profonditaRichiesta,
	    		@RequestHeader HttpHeaders headers) {
		 
		 log.debug("MOCK - getAggregatiCosti (clienti/{rifCliente})");
		 log.debug("MOCK - rifCliente = ["+rifCliente+"] - numLinea=["+msisdn+"]");
		 log.debug("MOCK - HttpHeaders = ["+headers+"]");
		 log.debug("MOCK - codiceOperazione = ["+codiceOperazione+"] - clientType = ["+clientType+"] - profonditaRichiesta = ["+profonditaRichiesta+"] ");

		 
		 GateSenderAggregatiCostiResponse response = new GateSenderAggregatiCostiResponse();

		 List<Category> categoryList = new ArrayList<Category>();
		 
		 Category ricariche = new Category();
		 ricariche.setCategoryId("CAT01");
		 ricariche.setTotalCost(15.00);
		 ricariche.setCategoryDescription("ric");
		 categoryList.add(ricariche);
		 
		 Category attivaz = new Category();
		 attivaz.setCategoryId("CAT02");
		 attivaz.setTotalCost(14.00);
		 attivaz.setCategoryDescription("attivazioni");
		 categoryList.add(attivaz);
		 

		 Category altro = new Category();
		 altro.setCategoryId("CAT03");
		 altro.setTotalCost(14.00);
		 altro.setCategoryDescription("altro");
		 categoryList.add(altro);
		 

		 //--
		 Category rate = new Category();
		 rate.setCategoryId("CAT04");
		 rate.setTotalCost(120.00);
		 rate.setCategoryDescription("rate");
		 categoryList.add(rate);

		 Category rinnoviOff = new Category();
		 rinnoviOff.setCategoryId("CAT05");
		 rinnoviOff.setTotalCost(2.00);
		 rinnoviOff.setCategoryDescription("rinnovi off");
		 categoryList.add(rinnoviOff);

		 
		 response.setCategoryList(categoryList);
		 response.setEsito("0");
		 
		 ErrorResponse error = new ErrorResponse();
		 error.setErrorCode("-150");
		 error.setErrorDescription("...");
		 response.setErrorResponse(error);
		 
		 try {
	        	ObjectMapper mapper = new ObjectMapper();
	        	log.info("MOCK - RESPONSE AS JSON = ["+mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response)+"]");
		 }
		 catch(Exception ex) {
			 log.error("MOCK ERROR " + ex);
		 }
		 
		 return response;
		 
		 
		 
	 };
	
	
}
