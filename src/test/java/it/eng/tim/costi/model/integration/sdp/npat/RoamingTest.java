package it.eng.tim.costi.model.integration.sdp.npat;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import it.eng.tim.costi.model.integration.sdp.gateSender.Category;

@RunWith(MockitoJUnitRunner.class)
public class RoamingTest {

	
	 private Roaming classToTest;

	    @Before
	    public void init(){
	    	classToTest = new Roaming();
	    }


	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull1(){
		 assertTrue(classToTest.getRoamingCCRMOC().equals(null));
	     //assertTrue(Constants.Subsystems.contains("MYTIMAPP"));

	  }


	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull2(){
		 assertTrue(classToTest.getRoamingCCRMTC().equals(null));
	     //assertTrue(Constants.Subsystems.contains("MYTIMAPP"));

	  }

	 
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull3(){
		 assertTrue(classToTest.getRoamingCCRRCF().equals(null));
	     //assertTrue(Constants.Subsystems.contains("MYTIMAPP"));

	  }

	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull4(){
		 assertTrue(classToTest.getRoamingOPSCPPITZ().equals(null));
	     //assertTrue(Constants.Subsystems.contains("MYTIMAPP"));

	  }

	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull5(){
		 assertTrue(classToTest.getRoamingOPSCRCF().equals(null));
	     //assertTrue(Constants.Subsystems.contains("MYTIMAPP"));

	  }

	 
}
