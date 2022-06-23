package com.practice.spring.ecom.customer.client.datamanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.spring.ecom.customer.models.CustomerLogin;
import com.practice.spring.ecom.customer.utils.EComUtils;
import com.practice.spring.ecom.customer.utils.RestClient;

@Service
public class CustomerLoginDatamanagerClientImpl implements CustomerLoginDatamanagerClient{

	private RestClient restClient;
	EComUtils<CustomerLogin> ecomUtils;
	
	@Autowired
	public CustomerLoginDatamanagerClientImpl(RestClient restClient,EComUtils<CustomerLogin> eComUtils) {
		this.restClient = restClient;
		this.ecomUtils=eComUtils;
	}

	@Override
	public String login(CustomerLogin credentials) {
		
		return restClient.post("/data/customer-login/login", ecomUtils.getJson(credentials));
	}

	@Override
	public String signup(CustomerLogin credentials) {
		return restClient.post("/data/customer-login/signup", ecomUtils.getJson(credentials));
	}

	@Override
	public void verify(String email) {
		// TODO Auto-generated method stub
		
	}

}
