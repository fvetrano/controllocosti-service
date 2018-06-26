package it.eng.tim.costi.model.integration.sdp.npat;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class DatiTest {

	
	private Dati classToTest;
	
	 @Before
	    public void init(){
	    	classToTest = new Dati();
	    }

	 
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull1(){
		 classToTest.getCamel().equals(null);
	 }
	 
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull2(){
		 classToTest.getGprs().equals(null);
	 }
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull3(){
		 classToTest.getGprsestero().equals(null);
	 }
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull4(){
		 classToTest.getGprsevento().equals(null);
	 }
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull5(){
		 classToTest.getMmsentranti().equals(null);
	 }
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull6(){
		 classToTest.getMmsentrantiDaLA().equals(null);
	 }
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull7(){
		 classToTest.getMmsinviati().equals(null);
	 }
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull8(){
		 classToTest.getMmsinviatiRoaming().equals(null);
	 }
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull9(){
		 classToTest.getMmsinviatiVsLA().equals(null);
	 }
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull10(){
		 classToTest.getMmsricevutoDaLA().equals(null);
	 }
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull11(){
		 classToTest.getMmsricevutoTIMPrime().equals(null);
	 }

	 
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull12(){
		 classToTest.getRcs().equals(null);
	 }
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull13(){
		 classToTest.getServiziContenutoWAP().equals(null);
	 }
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull14(){
		 classToTest.getWap().equals(null);
	 }
	 @Test(expected = java.lang.NullPointerException.class)
	  public void testNull15(){
		 classToTest.getWapevento().equals(null);
	 }
	 
	 
	

	
}
