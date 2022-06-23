package com.practice.spring.ecom.datamanager.services;

import java.util.List;

import com.practice.spring.ecom.datamanager.models.Cart;
import com.practice.spring.ecom.datamanager.models.Product;

public interface CartService {
	Cart addToCart(Cart cart);
	
	void emptyCart(String email);
	
	List<Product> getCart(String email);
}
