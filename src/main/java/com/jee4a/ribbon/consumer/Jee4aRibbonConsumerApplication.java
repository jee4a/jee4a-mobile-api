package com.jee4a.ribbon.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan("com.jee4a")
@EnableDiscoveryClient
@SpringBootApplication
public class Jee4aRibbonConsumerApplication {

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate() ;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Jee4aRibbonConsumerApplication.class, args);
	}
}
