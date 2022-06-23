package com.practice.spring.ecom.cart.utils;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class EComUtils <T>{
	public static final String NEW = "new";
	public static final String UPDATE = "update";
	public static final String DELETE = "delete";
	
	public  String getJson(T credentials) {
		Gson gson = new Gson();
		String jsonString= gson.toJson(credentials);
		System.out.println(jsonString);
		return jsonString;
	}
	
}

