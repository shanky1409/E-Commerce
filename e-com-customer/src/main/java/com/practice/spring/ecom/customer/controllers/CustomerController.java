package com.practice.spring.ecom.customer.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.spring.ecom.customer.models.Customer;
import com.practice.spring.ecom.customer.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private CustomerService customerService;
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService= customerService;
	}
	
	@RequestMapping({"","/list"})
	public String getAllCustomer(Model model) {
		model.addAttribute("customers", customerService.getAllCustomers());
		return "customers/customers";
	}
	
	@RequestMapping("/{id}")
	public String getCustomer(@PathVariable UUID id, Model model) {
		model.addAttribute("customer", customerService.getCustomerById(id));
		return "customers/customer";
	}
	
	@RequestMapping("/new")
	public String addCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "customers/customerForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Customer addOrUpdateCustomer(@RequestBody Customer customer) {
		if(customer == null) {
			throw new RuntimeException("Customer object is null");
		}
		return customerService.addOrUpdateCustomer(customer);
	}
	
	@RequestMapping("/edit/{id}")
	public String editCustomer(@PathVariable UUID id, Model model) {
		model.addAttribute("customer", customerService.getCustomerById(id));
		return "customers/customerForm";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable UUID id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer";
	}

}
