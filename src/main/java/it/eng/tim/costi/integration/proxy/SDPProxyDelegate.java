package it.eng.tim.costi.integration.proxy;

import static it.eng.tim.costi.util.IdsGenerator.generateIdHexadecimal;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import it.eng.tim.costi.integration.client.SDPClientForGateSender;
import it.eng.tim.costi.integration.client.SDPClientForNPAT;
import it.eng.tim.costi.model.integration.sdp.gateSender.GateSenderAggregatiCostiResponse;
import it.eng.tim.costi.model.integration.sdp.npat.QueryRiepilogoCostiBean;
import it.eng.tim.costi.model.integration.sdp.npat.StatisticheTrafficoTOTResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
class SDPProxyDelegate {

    private SDPClientForGateSender sdpClientForGS;
    private SDPClientForNPAT sdpClientForNPAT;

    
    @Autowired
    SDPProxyDelegate(SDPClientForGateSender creditClient, SDPClientForNPAT sdpClientForNPAT) {
        this.sdpClientForGS = creditClient;
        this.sdpClientForNPAT = sdpClientForNPAT;
    }


    
    @HystrixCommand()
    ResponseEntity<GateSenderAggregatiCostiResponse> getAggregatiCosti(String rifCliente, String msisdn, 
    		String codiceOperazione, String clientType,
    		String profonditaRichiesta, 
    		HttpHeaders headers) {
    	
    	log.debug("SDPProxyDelegate.getAggregatiCosti ("+rifCliente+")");
    	updateHeaders(headers);
        return sdpClientForGS.getAggregatiCosti(rifCliente, msisdn, codiceOperazione, clientType, profonditaRichiesta, headers);
        
    }
   
    
    @HystrixCommand()
    ResponseEntity<StatisticheTrafficoTOTResponse> getStatisticheTrafficoTOT(String rifCliente,
    		String msisdn, QueryRiepilogoCostiBean requestBean,
    		HttpHeaders headers){
    	
    	
    	log.debug("SDPProxyDelegate.getStatisticheTrafficoTOT ("+rifCliente+"/"+msisdn+")");
    	updateHeaders(headers);
    	return sdpClientForNPAT.getStatisticheTrafficoTOT(rifCliente, msisdn, requestBean, headers);
    	
    }
    
    
    
    
    //FALLBACK
    
    @SuppressWarnings("unused")
    ResponseEntity<StatisticheTrafficoTOTResponse> reliableStatisticheTrafficoTOT(String rifCliente, String msisdn, QueryRiepilogoCostiBean requestBean, HttpHeaders headers, Throwable throwable) {
        return ProxyTemplate.getFallbackResponse(throwable);
    }
    
    
    private void updateHeaders(HttpHeaders headers) {
    	
    	Date now = new Date(System.currentTimeMillis());
    	
    	headers.set("MessageID", generateIdHexadecimal(24));
    	headers.set("SourceSystem", "CBE");
    	
    	headers.set("interactionDate-Date", getDate(now));
    	headers.set("interactionDate-Time", getTime(now));

    	
    }
    
    
    
	private static String getTime(Date d){
		SimpleDateFormat sdfTime = new SimpleDateFormat ( "HH:mm:ss.SSS" );
		return sdfTime.format(d);
	}

	private static String getDate(Date d){
		SimpleDateFormat sdfDate = new SimpleDateFormat ( "yyyy-MM-dd" );
		return sdfDate.format(d);
	}
	
    
}
