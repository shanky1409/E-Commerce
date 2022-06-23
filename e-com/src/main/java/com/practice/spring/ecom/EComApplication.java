package com.practice.spring.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EComApplication {

	public static void main(String[] args) {
		SpringApplication.run(EComApplication.class, args);
		System.out.println("started");
	}

}
