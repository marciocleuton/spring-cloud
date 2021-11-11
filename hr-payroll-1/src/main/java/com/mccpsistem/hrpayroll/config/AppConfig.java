package com.mccpsistem.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	@Bean
	public RestTemplate restTemplate(){
		
		//Dessa forma esta sendo implementado o padrão de projeto Sigleto. De estancai unica
		return new RestTemplate();
	}

}
