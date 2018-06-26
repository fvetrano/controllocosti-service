package it.eng.tim.costi.validation;

import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;

import it.eng.tim.costi.model.configuration.ServiceConstants;
import it.eng.tim.costi.model.web.ControlloCostiRequest;


public class CostiControllerValidator {

    CostiControllerValidator() {}

    /*
    public static boolean validate(ScratchCardRequest request){
        return request != null
                && !StringUtils.isEmpty(request.getCardNumber())
                && !StringUtils.isEmpty(request.getFromMsisdn())
                && !StringUtils.isEmpty(request.getToMsisdn())
                && Constants.Subsystems.contains(request.getSubSys());
    }
    */

    
    public static boolean validate(HttpHeaders headers, ControlloCostiRequest request){
        
    	if(headers == null || StringUtils.isEmpty(headers.getFirst(ServiceConstants.JWT_SESSION_HEADER_NAME)) ) {
    		
    		return false;
    	}
    	
    	
    	return true;
    }

    
    public static boolean checkValidMsisdn(String requestMsisdn, String jwtMsisdnList) {
    	boolean res = true;
    	
    	//todo...
    	return res;
    }
    
}
