package com.practice.spring.ecom.datamanager.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.spring.ecom.datamanager.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
