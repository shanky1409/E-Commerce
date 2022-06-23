package com.practice.spring.ecom.datamanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.practice.spring.ecom.datamanager.models.Customer;
import com.practice.spring.ecom.datamanager.services.CustomerService;

@RestController
@RequestMapping("/data/customer")
public class CustomerController {

	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}


	@RequestMapping(method = RequestMethod.POST)
	public Customer saveCustomer(@RequestBody String gson) {
		Customer customer = new Gson().fromJson(gson, Customer.class);
		return customerService.addCustomer(customer);
	}
	
}
