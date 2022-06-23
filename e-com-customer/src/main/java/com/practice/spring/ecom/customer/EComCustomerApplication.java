package com.practice.spring.ecom.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EComCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EComCustomerApplication.class, args);
	}

}
