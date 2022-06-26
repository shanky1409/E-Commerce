package com.practice.spring.ecom.customer.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.practice.spring.ecom.customer.client.datamanager.CustomerLoginDatamanagerClient;
import com.practice.spring.ecom.customer.models.Customer;
import com.practice.spring.ecom.customer.models.CustomerLogin;
import com.practice.spring.ecom.customer.services.mails.MailService;
import com.practice.spring.ecom.customer.utils.EComUtils;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {

	CustomerLoginDatamanagerClient customerLoginDatamanagerClient;
	private MailService mailService;
	
	@Autowired
	public CustomerLoginServiceImpl(CustomerLoginDatamanagerClient customerLoginDatamanagerClient, MailService mailService) {
		this.customerLoginDatamanagerClient = customerLoginDatamanagerClient;
		this.mailService=mailService;
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
		String email= customerLoginDatamanagerClient.signup(creds);
		if(!email.isEmpty()) {
			mailService.sendMail(new Gson().fromJson(email, Map.class).get("email").toString(), EComUtils.NEW);
		}
		return email;
	}

}
