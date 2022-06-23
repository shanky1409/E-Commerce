package com.practice.spring.ecom.customer.services;

import java.util.List;
import java.util.UUID;

import com.practice.spring.ecom.customer.models.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(UUID id);
	public Customer addOrUpdateCustomer(Customer customer);
	public void deleteCustomer(UUID id);
}
