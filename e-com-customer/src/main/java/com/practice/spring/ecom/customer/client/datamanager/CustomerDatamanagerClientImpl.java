package com.practice.spring.ecom.customer.client.datamanager;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.practice.spring.ecom.customer.models.Customer;
import com.practice.spring.ecom.customer.utils.EComUtils;
import com.practice.spring.ecom.customer.utils.RestClient;

@Service
public class CustomerDatamanagerClientImpl implements CustomerDatamanagerClient{

	private RestClient restClient;
	EComUtils<Customer> ecomUtils;
	public CustomerDatamanagerClientImpl(RestClient restClient,EComUtils<Customer> ecomUtils) {
		this.restClient=restClient;
		this.ecomUtils=ecomUtils;
	}
	@Override
	public Customer addCustomer(Customer customer) {
		String response= restClient.post("/data/customer", ecomUtils.getJson(customer));
		return new Gson().fromJson(response, Customer.class);
	}

}
