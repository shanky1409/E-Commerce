package com.practice.spring.ecom.customer.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.spring.ecom.customer.models.Address;
import com.practice.spring.ecom.customer.models.Customer;
import com.practice.spring.ecom.customer.services.mails.MailService;
import com.practice.spring.ecom.customer.utils.EComUtils;

@Service
public class CustomerServiceMockImpl implements CustomerService {

	private Map<UUID,Customer> customers;
	private MailService mailService;
	
	@Autowired
	public CustomerServiceMockImpl(MailService mailService) {
		loadAddCustomers();
		this.mailService= mailService;
	}

	private void loadAddCustomers() {
		
		customers = new HashMap<>();
		
		UUID randomUuid= UUID.randomUUID();
		Address address = new Address("line1", "line2", "city1", "state1", "zipcode");
		customers.put(randomUuid, new Customer(randomUuid,"fname1","lname1","email1@mail.com","9999",address));
		
		randomUuid= UUID.randomUUID();
		address = new Address("line1", "line2", "city2", "state2", "zipcode2");
		customers.put(randomUuid, new Customer(randomUuid,"fname2","lname2","email2@mail.com","9999",address));
		
		randomUuid= UUID.randomUUID();
		address = new Address("line1", "line2", "city3", "state3", "zipcode3");
		customers.put(randomUuid, new Customer(randomUuid,"fname3","lname3","email3@mail.com","9999",address));
		
		randomUuid= UUID.randomUUID();
		address = new Address("line1", "line2", "city4", "state4", "zipcode4");
		customers.put(randomUuid, new Customer(randomUuid,"fname4","lname4","email4@mail.com","9999",address));
		
		randomUuid= UUID.randomUUID();
		address = new Address("line1", "line2", "city5", "state5", "zipcode5");
		customers.put(randomUuid, new Customer(randomUuid,"fname5","lname4","email5@mail.com","9999",address));
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		return new ArrayList<Customer>(customers.values());
	}

	@Override
	public Customer getCustomerById(UUID id) {
		return customers.get(id);
	}

	@Override
	public Customer addOrUpdateCustomer(Customer customer) {
		if(customer !=null) {
			if(customers.containsKey(customer.getId())) {
				customers.put(customer.getId(), customer);
				mailService.sendMail(customer.getEmail(), EComUtils.UPDATE);
			}
			else {
				System.out.println(customer.getAddress());
				UUID uuid = UUID.randomUUID();
				customer.setId(uuid);
				customers.put(uuid, customer);
				mailService.sendMail(customer.getEmail(), EComUtils.NEW);
			}
			return customer;
		}
		throw new RuntimeException("Customer cannot be null");
		
	}

	@Override
	public void deleteCustomer(UUID id) {
		Customer customer =customers.remove(id);
		mailService.sendMail(customer.getEmail(),EComUtils.DELETE);
	}

}
