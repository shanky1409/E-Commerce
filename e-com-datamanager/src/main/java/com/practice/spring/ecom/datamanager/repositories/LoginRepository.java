package com.practice.spring.ecom.datamanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.spring.ecom.datamanager.models.CustomerLogin;

@Repository
public interface LoginRepository extends JpaRepository<CustomerLogin, String> {

	public CustomerLogin findByEmailAndPassword(String email, String password);
}
