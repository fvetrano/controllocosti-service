package it.eng.tim.costi.model.integration.sdp.npat;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MocTest {

	
	private Moc mocToTest;
	
	 @Before
	    public void init(){
	    	mocToTest = new Moc();
	    }

	 
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull1(){
		 assertTrue(mocToTest.getMoc916() .equals(null));
	  }

	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull2(){
		 assertTrue(mocToTest.getMoctariffatoInt() .equals(null));
	  }

	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull3(){
		 assertTrue(mocToTest.getMoctariffatoNaz() .equals(null));
	  }

	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull4(){
		 assertTrue(mocToTest.getVoltetariffatoInt() .equals(null));
	  }

	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull5(){
		 assertTrue(mocToTest.getVoltetariffatoNaz() .equals(null));
	  }

	 

	 
	 
	 
	 
}
