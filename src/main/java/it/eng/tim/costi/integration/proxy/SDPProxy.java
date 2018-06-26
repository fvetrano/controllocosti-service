package it.eng.tim.costi.integration.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import it.eng.tim.costi.model.integration.sdp.gateSender.GateSenderAggregatiCostiResponse;
import it.eng.tim.costi.model.integration.sdp.npat.QueryRiepilogoCostiBean;
import it.eng.tim.costi.model.integration.sdp.npat.StatisticheTrafficoTOTResponse;
import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class SDPProxy extends ProxyTemplate {

    static final  String SUBSYSTEM_NAME = "SDP Service";
    
    private SDPProxyDelegate delegate;

    @Autowired
    public SDPProxy(SDPProxyDelegate delegate) {
        this.delegate = delegate;
    }

    
    public GateSenderAggregatiCostiResponse getAggregatiCosti(String rifCliente, String msisdn, 
    		String codiceOperazione, String clientType,
    		String profonditaRichiesta, 
    		HttpHeaders headers) {
    	
    	log.debug("SDPProxy.getAggregatiCosti ("+rifCliente+")");
    	return getBody(delegate.getAggregatiCosti(rifCliente, msisdn, codiceOperazione, clientType, profonditaRichiesta, headers));
    }
    
    
    
    
    public StatisticheTrafficoTOTResponse getStatisticheTrafficoTOT(String rifCliente,
    		String msisdn, QueryRiepilogoCostiBean requestBean,
    		HttpHeaders headers){
    	
    	
    	log.debug("SDPProxy.getStatisticheTrafficoTOT ("+rifCliente+"/"+msisdn+")");
    	return getBody(delegate.getStatisticheTrafficoTOT(rifCliente, msisdn, requestBean, headers));
    	
    }
    
    

    @Override
    String getSubsystemName() {
        return SUBSYSTEM_NAME;
    }
}
