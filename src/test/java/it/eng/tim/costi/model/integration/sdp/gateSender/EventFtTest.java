package it.eng.tim.costi.model.integration.sdp.gateSender;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import it.eng.tim.costi.model.integration.sdp.npat.Dati;

@RunWith(MockitoJUnitRunner.class)
public class EventFtTest {

	private EventFt classToTest;
	
	 @Before
	    public void init(){
	    	classToTest = new EventFt();
	    }

	 
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull1(){
		 assertTrue(classToTest.getActivationDateTime().equals(null));
	 }
	 
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull2(){
		 assertTrue(classToTest.getBasketName().equals(null));
	 }

	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull3(){
		 assertTrue(classToTest.getCategoryDescription().equals(null));
	 }

	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull4(){
		 assertTrue(classToTest.getCategoryId().equals(null));
	 }

	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull5(){
		 assertTrue(classToTest.getDefaultDescription().equals(null));
	 }

	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull6(){
		 assertTrue(classToTest.getDescriptionAdvancePayment().equals(null));
	 }

	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull7(){
		 assertTrue(classToTest.getDescriptionFee().equals(null));
	 }

	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull8(){
		 assertTrue(classToTest.getDetailedDescription().equals(null));
	 }
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull9(){
		 assertTrue(classToTest.getEcEventID().equals(null));
	 }

	 
}


