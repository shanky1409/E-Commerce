package com.practice.spring.ecom.datamanager.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.practice.spring.ecom.datamanager.models.CustomerLogin;
import com.practice.spring.ecom.datamanager.services.CustomerLoginService;

@RestController
@RequestMapping("/data/customer-login")
public class CustomerLoginController {
	
	private CustomerLoginService customerLoginService;
	
	@Autowired
	public CustomerLoginController(CustomerLoginService customerLoginService) {
		this.customerLoginService = customerLoginService;
	}
	
	@RequestMapping( path = "/login", method = RequestMethod.POST)
	public Boolean Login(@RequestBody String gson) {
		CustomerLogin creds = new Gson().fromJson(gson, CustomerLogin.class);
		return customerLoginService.login(creds);
	}
	
	@RequestMapping( path = "/signup", method = RequestMethod.POST, produces = "application/json")
	public Map<String,String> Singup(@RequestBody String gson) {
		CustomerLogin creds = new Gson().fromJson(gson, CustomerLogin.class);
		String customerEmail= customerLoginService.signup(creds);
		if(customerEmail!= null) {
			Map<String, String> hm= new HashMap<>();
			hm.put("email", customerEmail);
			return hm;
		}
		return null;
	}
	

}
