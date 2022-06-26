package com.practice.spring.ecom.customer.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClient {
	
	@Value("${ecom.datamanager.url}")
	private String serverUrl;
	private RestTemplate restTemplate;
	private HttpHeaders headers;
	private HttpStatus httpStatus;
	public RestClient() {
		this.restTemplate = new RestTemplate();
		this.headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "*/*");
	}
	
	public String get(String uri) {
		HttpEntity<String> requestEntity = new HttpEntity<>("",headers);
		ResponseEntity<String> response = restTemplate.exchange(serverUrl+uri, HttpMethod.GET,requestEntity,String.class);
		return response.getBody();
	}
	
	public String post(String uri, String body) {
		HttpEntity<String> requestEntity = new HttpEntity<>(body,headers);
		ResponseEntity<String> response = restTemplate.exchange(serverUrl+uri, HttpMethod.POST,requestEntity,String.class);
		return response.getBody();
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
}
