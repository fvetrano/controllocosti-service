package it.eng.tim.costi.integration.proxy;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ProfileProxyTest {

    @Mock
    SDPProxyDelegate delegate;

    SDPProxy proxy;

    @Before
    public void init(){
        proxy = new SDPProxy(delegate);
    }

    @After
    public void cleanup(){
        Mockito.reset(delegate);
    }

    
    
    @Test
    public void authorizeLineForRecharge() throws Exception {

    	//proxy
    }	
    /*
    
    @Test
    public void authorizeLineForRecharge() throws Exception {

        String lineNum = "lineNum";
        Mockito.when(delegate.authorizeLineForRecharge(Mockito.anyString()))
                .thenReturn(new ResponseEntity<>(
                        new RechargeAuthorizationResponse("A", lineNum, "OK"),
                        HttpStatus.OK));

        RechargeAuthorizationResponse rechargeAuthorizationResponse = proxy.authorizeLineForRecharge(lineNum);
        assertNotNull(rechargeAuthorizationResponse);
        assertEquals(lineNum, rechargeAuthorizationResponse.getNumLinea());
        assertEquals("A", rechargeAuthorizationResponse.getComando());
        assertEquals("OK", rechargeAuthorizationResponse.getEsito());

    }


    @Test
    public void rechargeWithScratchCard() throws Exception {
        String lineNum = "lineNum";
        String amount = "amount";
        Mockito.when(delegate.rechargeWithScratchCard(Mockito.anyObject()))
                .thenReturn(new ResponseEntity<>(
                        new ScratchCardResponse("A", lineNum, "OK", amount),
                        HttpStatus.OK));

        ScratchCardResponse scratchCardResponse = proxy.rechargeWithScratchCard(new ScratchCardRequest());
        assertNotNull(scratchCardResponse);
        assertEquals(lineNum, scratchCardResponse.getNumLinea());
        assertEquals(amount, scratchCardResponse.getImporto());
        assertEquals("A", scratchCardResponse.getComando());
        assertEquals("OK", scratchCardResponse.getEsito());
    }


	*/

    @Test
    public void getSubsystemName() throws Exception {
        assertEquals(SDPProxy.SUBSYSTEM_NAME, proxy.getSubsystemName());
    }

}