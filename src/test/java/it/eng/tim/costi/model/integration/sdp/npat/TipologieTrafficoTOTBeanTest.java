package it.eng.tim.costi.model.integration.sdp.npat;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TipologieTrafficoTOTBeanTest {

	private TipologieTrafficoTOTBean classToTest;
	
	 @Before
	    public void init(){
	    	classToTest = new TipologieTrafficoTOTBean();
	    }

	 

	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull2(){
		 assertTrue(classToTest.getTipo().equals(null));
	 }
	 
	
	
}
