package com.practice.spring.ecom.customer.client.datamanager;

import com.practice.spring.ecom.customer.models.CustomerLogin;

public interface CustomerLoginDatamanagerClient {

	String login(CustomerLogin credentials);
	String signup(CustomerLogin credentials);
	void verify(String email);
}
