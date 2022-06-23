package com.practice.spring.ecom.cart.models;

import java.util.UUID;

public class Cart {
	
	private UUID id;
	private String email;
	private String productId;
	public Cart(String email, String productId) {
		this.email = email;
		this.productId = productId;
	}
	
	
	public Cart() {
	}


	public Cart(UUID id, String email, String productId) {
		super();
		this.id = id;
		this.email = email;
		this.productId = productId;
	}

	
	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	@Override
	public String toString() {
		return "AddCart [email=" + email + ", productId=" + productId + "]";
	}
	
	

}
