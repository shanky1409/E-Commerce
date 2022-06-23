package com.practice.spring.ecom.datamanager.services;

import com.practice.spring.ecom.datamanager.models.CustomerLogin;

public interface CustomerLoginService {
	Boolean login(CustomerLogin creds);

	String signup(CustomerLogin creds);
}
