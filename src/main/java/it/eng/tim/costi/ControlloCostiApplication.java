package it.eng.tim.costi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
@ComponentScan(basePackages={"it.eng.tim.costi"})
public class ControlloCostiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlloCostiApplication.class, args);
	}

}