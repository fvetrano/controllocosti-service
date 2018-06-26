package it.eng.tim.costi.service;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;

import it.eng.tim.costi.integration.proxy.SDPProxy;
import it.eng.tim.costi.model.exception.ServiceException;
import it.eng.tim.costi.model.integration.sdp.npat.Dati;
import it.eng.tim.costi.model.integration.sdp.npat.Moc;

/**
 * Created by alongo on 30/04/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class ControlloCostiServiceTest {

    @Mock
    SDPProxy proxy;

    private ControlloCostiService service;

    @Before
    public void init(){
        service = new ControlloCostiService(proxy);
    }

    @After
    public void cleanup(){
        Mockito.reset(proxy);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void authorizeFailsOnNUllRifCliente() throws Exception {
    	service.getControlloCostiAggregato(null, null);
        //service.getUserProfileInfo(null);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void authorizeFailsOnNUllRifCliente2() throws Exception {
    	service.getControlloCostiAggregato(null, getValidHttpHeaders());
        //service.getUserProfileInfo(null);
    }
    
    
    @Test(expected = java.lang.NullPointerException.class)
    public void authorizeFailsOnNUllRifClienteA() throws Exception {
    	service.getControlloCostiAggregato(null, null);
        //service.getUserProfileInfo(null);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void authorizeFailsOnNUllRifClienteA2() throws Exception {
    	service.getControlloCostiAggregato(null, getValidHttpHeaders());
        //service.getUserProfileInfo(null);
    }
    
    
    
    
    
    private HttpHeaders getValidHttpHeaders() {
    	HttpHeaders headers = new HttpHeaders();
    	
    	headers.add("sessionJWT", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImlzcyI6Imh0dHBzOi8vZHQtcy1hcGlndzAxLnRlbGVjb21pdGFsaWEubG9jYWw6ODQ0MyJ9.ew0KCSJ1c2VyQWNjb3VudCI6ICJwcmltZTFAdGltLml0IiwNCgkiY2ZfcGl2YSI6ICJaSk9SSkE2MkQyMUwyMTlQIiwNCgkiZGNhQ29vY2tpZSI6ICJaamRqWldRNFlXVXRORFV3TVMwME1HTmxMV0psWkdNdFlURXhabVZtT1RWbFpESm1YMTlmUkVOQlZWUklYMEZWVkVoZlEwOVBTMGxGWDE5ZkxuUnBiUzVwZEE9PSIsDQoJImFjY291bnRUeXBlIjogIkFDQ09VTlRfVU5JQ08iDQp9.t0dJFeFFF5v2FHZkI7y2ALqg4iAGav2_XSqFYzIFpOk");
    	
    	return headers;
    }
    
    

}