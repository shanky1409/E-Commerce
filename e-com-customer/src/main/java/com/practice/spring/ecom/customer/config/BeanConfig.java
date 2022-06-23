package com.practice.spring.ecom.customer.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

	@Bean("httpHeaders")
	public HttpHeaders getHttpHeaders() {
		return new HttpHeaders();
	}
	@Bean("restTemplate")
	public RestTemplate getRestTemplate() {
		return new RestTemplateBuilder().build();
	}
}
