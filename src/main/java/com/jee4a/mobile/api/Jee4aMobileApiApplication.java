package com.jee4a.mobile.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan("com.jee4a")
@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
public class Jee4aMobileApiApplication {

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate() ;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Jee4aMobileApiApplication.class, args);
	}
}
