package it.eng.tim.costi;

import org.junit.Test;

import it.eng.tim.costi.SwaggerConfiguration;

import static org.junit.Assert.*;



public class SwaggerConfigurationTest {

    @Test
    public void api() throws Exception {
        SwaggerConfiguration swaggerConfiguration = new SwaggerConfiguration();
        assertNotNull(swaggerConfiguration.api());
    }

}