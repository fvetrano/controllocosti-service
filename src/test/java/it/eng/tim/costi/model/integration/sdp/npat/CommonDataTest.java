package it.eng.tim.costi.model.integration.sdp.npat;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommonDataTest {

	
	private CommonData classToTest;
	
	 @Before
	    public void init(){
	    	classToTest = new CommonData();
	    }

	 

	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull1(){
		 assertTrue(classToTest.getDataFine().equals(null));
	 }
	 

	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull2(){
		 assertTrue(classToTest.getDataInizio().equals(null));
	 }
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull3(){
		 assertTrue(classToTest.getOperatore().equals(null));
	 }
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull4(){
		 assertTrue(classToTest.getSubSys().equals(null));
	 }
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull5(){
		 assertTrue(classToTest.getTutteLeTipologie().equals(null));
	 }
	 
	 
	 
}
