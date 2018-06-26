package it.eng.tim.costi.web;

import java.util.HashMap;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.eng.tim.costi.model.configuration.ApplicationConfiguration;
import it.eng.tim.costi.model.configuration.ServiceConstants;
import it.eng.tim.costi.model.domain.ServiceRequest;
import it.eng.tim.costi.model.exception.BadRequestException;
import it.eng.tim.costi.model.exception.NotAuthorizedException;
import it.eng.tim.costi.model.exception.ServiceException;
import it.eng.tim.costi.model.web.AggregatoCostiResponse;
import it.eng.tim.costi.model.web.ControlloCostiRequest;
import it.eng.tim.costi.model.web.ControlloCostiResponse;
import it.eng.tim.costi.model.web.ErrorResponse;
import it.eng.tim.costi.service.ControlloCostiService;
import it.eng.tim.costi.util.ExceptionUtil;
import it.eng.tim.costi.validation.CostiControllerValidator;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api/movements")
@Api("Controller exposing controllo costi operations")
@Slf4j
//@SwaggerDefinition(tags = { @Tag(name = "My Swagger Resource", description = "Meaningful stuff in here") })
public class ControlloCostiController < T extends ControlloCostiResponse >{

    private ControlloCostiService controlloCostiService;
    private ApplicationConfiguration configuration;
    //private StaticContentService staticContentService;
    
    private static final int GAP = 10000;
    private static final Random __randomCounter = new Random();
    
    @Autowired
    public ControlloCostiController(ControlloCostiService controlloCostiService, ApplicationConfiguration conf) {
        this.controlloCostiService = controlloCostiService;
        configuration = conf;
        //this.staticContentService = staticContentService;
    }

    
    
    @RequestMapping(method = RequestMethod.POST, value = "/{msisdn}/AGG00", produces = "application/json")
    @ApiOperation(value = "Controllo costi vista aggregata"  )
    //@ApiParam(value = "name that need to be updated", required = true)

    @ApiImplicitParams({
        @ApiImplicitParam(name = "SessionID", value = "PARAMETRO PASSANTE. Individua la sessione utente. Formato: UUID 24 caratteri esadecimali", required = true, dataType = "string", paramType = "header"),
        @ApiImplicitParam(name = "BusinessID", value = "PARAMETRO PASSANTE. Individua il processo di business. Formato: UUID 24 caratteri esadecimali", required = true, dataType = "string", paramType = "header"),

        @ApiImplicitParam(name = "MessageID", value = "PARAMETRO NON PASSANTE. Identificativo univoco del singolo messaggio. Formato: UUID 24 caratteri esadecimali", required = true, dataType = "string", paramType = "header"),
        @ApiImplicitParam(name = "TransactionID", value = "PARAMETRO PASSANTE. Identificativo univoco della transazione. Formato: UUID 24 caratteri esadecimali", required = true, dataType = "string", paramType = "header"),
        @ApiImplicitParam(name = "SourceSystem", value = "PARAMETRO NON PASSANTE. Identificativo del sistema chiamante. LOV: WEB, APP, MSITE, CBE, DCA", required = true, dataType = "string", paramType = "header"),
        @ApiImplicitParam(name = "Channel", value = "PARAMETRO PASSANTE. Canale da cui parte la richiesta. LOV: MYTIMWEB, MYTIMAPP, MYTIMMSITE", required = true, dataType = "string", paramType = "header"),
        
        @ApiImplicitParam(name = "InteractionDate-Date", value = "Data interazione utente iniziale. Creato da APP FE, sovrascritto da CBE e poi passante per gli altri sistemi. Formato: YYYY-MM-DD", required = true, dataType = "string", paramType = "header"),
        @ApiImplicitParam(name = "InteractionDate-Time", value = "Orario interazione utente iniziale. Creato da APP FE, sovrascritto da CBE e poi passante per gli altri sistemi. Formato: HH:MM:SS", required = true, dataType = "string", paramType = "header"),
        @ApiImplicitParam(name = "DeviceType", value = "Solo per APP. Indica il tipo di device da cui viene la richiesta. Passante tra APP FE e CBE. LOV: ANDROID, SMARTPHONE, TABLET, I-PAD, IPHONE", required = true, dataType = "string", paramType = "header"),
        
    })
    
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = AggregatoCostiResponse.class),
            @ApiResponse(code = 401, message = "User not authenticated", response = ErrorResponse.class),
            @ApiResponse(code = 408, message = "Timeout", response = ErrorResponse.class),
            @ApiResponse(code = 422, message = "Cannot parse source JSON", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Generic error", response = ErrorResponse.class),
            @ApiResponse(code = 503, message = "Service unavailable", response = ErrorResponse.class)
    })
    public AggregatoCostiResponse getMovementsAggregati(@RequestHeader HttpHeaders headers, 
												@RequestHeader(value = "businessID", required = false) String xBusinessId,    		
												@RequestHeader(value = "messageID", required = false) String xMessageID,    		
												@RequestHeader(value = "transactionID", required = false) String xTransactionID,    		
												@RequestHeader(value = "channel", required = false) String xChannel,    		
												@RequestHeader(value = "sourceSystem", required = false) String xSourceSystem,    		
												@RequestHeader(value = "sessionID", required = false) String xSessionID, 
    											@PathVariable("msisdn") String msisdn,
    											@RequestBody ControlloCostiRequest request
    											 ) 
    							throws ServiceException, NotAuthorizedException, BadRequestException {

    	
    	log.info("getMovementsAggregati. RequestBody: " + request);
    	long start = System.currentTimeMillis();
    	
    	if(!CostiControllerValidator.validate(headers, request)) {
    		throw new BadRequestException("Missing/Wrong headers in getMovements");
    	}
    			
		
    	String sessionJWTString = headers.getFirst(ServiceConstants.JWT_SESSION_HEADER_NAME);
    	
    	log.debug("sessionJWTString=["+sessionJWTString+"]");
    	
    	
    	String cfCliente = null;
    	
    	if(sessionJWTString!=null) {
    		try {
            	Jwt token = JwtHelper.decode(sessionJWTString);
            	//token.verifySignature(arg0);
            	
            	String decodedToken = token.getClaims();
            	log.debug("decoded token=["+decodedToken+"]");
            	
            	HashMap sessionJWTMap = new ObjectMapper().readValue(decodedToken, HashMap.class);
            	log.debug("sessionJWTMap=["+sessionJWTMap+"]");
    			
            	cfCliente = (String)sessionJWTMap.get("cf_piva");
            	
            	if(cfCliente == null) {
        			throw new ServiceException("Error in getting rifCliente from sessionJWT", "ERR001");
            	}

            	if(!CostiControllerValidator.checkValidMsisdn(msisdn, "")) {
            		log.error("Invalid msisdn ["+msisdn+"] not present in JWT");
            		throw new BadRequestException("Invalid msisdn");
            	}
            	
    		}
    		catch(Exception ex) {
    			log.error("Error in getting sessionJWT " + ex);
    			throw new BadRequestException("Error in getting sessionJWT");
    		}
    		
    	}
    	else {
    		//throw new BadRequestException("Missing sessionJWT");
    		throw new ServiceException("Missing sessionJWT","ERR001");
    	}
    	
    	
    	try {
    		
    		ServiceRequest serviceReq = new ServiceRequest();
    		serviceReq.setFiscalCode(cfCliente);
    		serviceReq.setMsisdn(msisdn);
    		serviceReq.setPeriod(request.getPeriod().toString());
    	
    		AggregatoCostiResponse response = controlloCostiService.getControlloCostiAggregato(serviceReq, headers);
    		
    		log.info(" Return response: " + response + "");
    		return response;
    		
    	}
    	catch(ServiceException se) {
    		throw se;
    	}
    	catch(Exception ex) {
    		log.error("Error in getMovementsAggregati " + ExceptionUtil.getStackTrace(ex));
    		
    		throw new ServiceException("Internal Error", "ERR002");
    	}
    	finally {
    		long end = System.currentTimeMillis();
        	log.info("Service work time ["+(end-start)+"] ms");
    	}
    }


  

    
	public static String generateID( final String prefix) {
	
		final StringBuilder buffer = new StringBuilder( prefix );
		buffer.append("_");
		buffer.append( ( __randomCounter.nextInt( 99 ) + 1 ) * GAP);
		return buffer.toString();
	}	
    
}
