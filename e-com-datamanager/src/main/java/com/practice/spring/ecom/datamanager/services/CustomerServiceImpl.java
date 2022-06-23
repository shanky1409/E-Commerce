package com.practice.spring.ecom.datamanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.spring.ecom.datamanager.models.Customer;
import com.practice.spring.ecom.datamanager.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository=customerRepository;
	}
	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}
