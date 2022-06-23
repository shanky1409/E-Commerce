package com.practice.spring.ecom.customer.services;

import com.practice.spring.ecom.customer.models.CustomerLogin;

public interface CustomerLoginService {
	String login(CustomerLogin creds);
	boolean verify(String email);
	String signUp(CustomerLogin creds);
}
