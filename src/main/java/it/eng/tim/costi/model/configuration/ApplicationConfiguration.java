package it.eng.tim.costi.model.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



@ConfigurationProperties(prefix = "application.config")
@Data
@Component
public class ApplicationConfiguration {

	//private String keystorePath;
	
	
	

}
