package com.practice.spring.ecom.cart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.spring.ecom.cart.models.Cart;
import com.practice.spring.ecom.cart.services.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	private CartService cartService;
	
	
	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Cart addToCart(@RequestBody Cart cart) {
		return cartService.addTocart(cart);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/get")
	public Object getCart(@RequestBody String email) {
		return cartService.getCartItems(email);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/empty-cart")
	public void emptyCart(@RequestBody String email) {
		 cartService.emptyCart(email);
	}

}
