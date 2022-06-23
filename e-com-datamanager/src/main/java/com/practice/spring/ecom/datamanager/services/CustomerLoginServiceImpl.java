package com.practice.spring.ecom.datamanager.services;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.practice.spring.ecom.datamanager.models.CustomerLogin;
import com.practice.spring.ecom.datamanager.repositories.LoginRepository;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService{

	private LoginRepository loginRepository;
	
	
	
	public CustomerLoginServiceImpl(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}



	@Override
	public Boolean login(CustomerLogin creds) {
		CustomerLogin user = loginRepository.findByEmailAndPassword(creds.getEmail(), creds.getPassword());
		if(user == null) {
			return false;
		}
		return true;
	}



	@Override
	public String signup(CustomerLogin creds) {
		try {
		loginRepository.findById(creds.getEmail()).get();
		
		}catch (NoSuchElementException ex) {
			CustomerLogin customer = loginRepository.save(creds);
			return customer.getEmail();
		}
		return null;
	}

}
