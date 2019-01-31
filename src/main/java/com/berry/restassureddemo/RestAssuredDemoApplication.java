package com.berry.restassureddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestAssuredDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestAssuredDemoApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
	  
	  return new RestTemplate();
	}

}

