package com.practice.spring.ecom.customer.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.spring.ecom.customer.models.CustomerLogin;
import com.practice.spring.ecom.customer.services.CustomerLoginService;

@RestController
@RequestMapping("/customer-login")
public class CustomerLoginController {

	private CustomerLoginService customerLoginService;

	@Autowired
	public CustomerLoginController(CustomerLoginService customerLoginService) {
		this.customerLoginService = customerLoginService;
	}
	
	@RequestMapping(method = RequestMethod.POST, path =  "/login")
	public String login(@RequestBody CustomerLogin creds) {
		System.out.println("email: "+creds.getEmail()+ " : password: "+ creds.getPassword());
		return customerLoginService.login(creds);
	}
	
	@RequestMapping(method = RequestMethod.POST, path =  "/verify")
	public boolean checkUser(@RequestBody Map<String, String> request) {;
		String email = request.get("email");
		
		return customerLoginService.verify(email);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/signup")
	public String signup(@RequestBody CustomerLogin creds) {
		if(creds == null) {
			throw new RuntimeException("Customer object is null");
		}
		return customerLoginService.signUp(creds);
	}
	
	
	
}
