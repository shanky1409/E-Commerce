package com.practice.spring.ecom.customer.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.practice.spring.ecom.customer.client.datamanager.CustomerDatamanagerClient;
import com.practice.spring.ecom.customer.models.Customer;

@Service
@Primary
public class CustomerServiceDbImpl implements CustomerService {

	private CustomerDatamanagerClient customerDatamanagerClient;
	
	@Autowired
	public CustomerServiceDbImpl(CustomerDatamanagerClient customerDatamanagerClient) {
		this.customerDatamanagerClient = customerDatamanagerClient;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer addOrUpdateCustomer(Customer customer) {
		System.out.println(customer);
		return customerDatamanagerClient.addCustomer(customer);
		
	}

	@Override
	public void deleteCustomer(UUID id) {
		// TODO Auto-generated method stub

	}

}
