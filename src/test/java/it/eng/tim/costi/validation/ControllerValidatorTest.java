package it.eng.tim.costi.validation;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import it.eng.tim.costi.model.web.ControlloCostiRequest;

/**
 * Created by alongo on 30/04/18.
 */
public class ControllerValidatorTest {

    @Test
    public void validatePrivateConstructor() throws Exception {
        new CostiControllerValidator();
    }

    
    
    @Test
    public void validateScratchCardRequestFailsOnNull() throws Exception {
        assertFalse(CostiControllerValidator.validate(null,null));
    }

    @Test
    public void validateScratchCardRequestFailsOnNull2() throws Exception {
        assertFalse(CostiControllerValidator.validate(null,new ControlloCostiRequest()));
    }
    

}