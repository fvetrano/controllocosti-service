package it.eng.tim.costi.model.integration.sdp.gateSender;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CategoryTest {

	 private Category classToTest;

	    @Before
	    public void init(){
	    	classToTest = new Category();
	    }


	 @Test(expected = java.lang.NullPointerException.class)
	  public void SubsystemsNotContainsNullOrEmty(){
		 assertTrue(classToTest.getCategoryId().equals(null));
	     //assertTrue(Constants.Subsystems.contains("MYTIMAPP"));

	  }

	 
	 @Test(expected = java.lang.NullPointerException.class)
	  public void SubsystemsNotContainsNullOrEmty2(){
		 assertTrue(classToTest.getCategoryDescription().equals(null));
	     //assertTrue(Constants.Subsystems.contains("MYTIMAPP"));

	  }



}
