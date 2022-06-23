package com.practice.spring.ecom.customer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.spring.ecom.customer.client.datamanager.CustomerLoginDatamanagerClient;
import com.practice.spring.ecom.customer.models.CustomerLogin;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {

	CustomerLoginDatamanagerClient customerLoginDatamanagerClient;
	
	@Autowired
	public CustomerLoginServiceImpl(CustomerLoginDatamanagerClient customerLoginDatamanagerClient) {
		this.customerLoginDatamanagerClient = customerLoginDatamanagerClient;
	}

	@Override
	public String login(CustomerLogin creds) {
		return customerLoginDatamanagerClient.login(creds);
	}

	@Override
	public boolean verify(String email) {
		return true;
	}

	@Override
	public String signUp(CustomerLogin creds) {
		return customerLoginDatamanagerClient.signup(creds);
	}

}
