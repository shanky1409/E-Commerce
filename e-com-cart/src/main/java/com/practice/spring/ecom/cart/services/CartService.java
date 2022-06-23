package com.practice.spring.ecom.cart.services;

import com.practice.spring.ecom.cart.models.Cart;

public interface CartService {
	Cart addTocart(Cart cart);
	
	void emptyCart(String email);
	
	Object getCartItems(String email);
}
