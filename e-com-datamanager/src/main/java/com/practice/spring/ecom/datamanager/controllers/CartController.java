package com.practice.spring.ecom.datamanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.practice.spring.ecom.datamanager.models.Cart;
import com.practice.spring.ecom.datamanager.models.Product;
import com.practice.spring.ecom.datamanager.services.CartService;

@RestController
@RequestMapping("/data/cart")
public class CartController {
	
	private CartService cartService;
	
	
	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Cart addToCart(@RequestBody String gson) {
		return cartService.addToCart(new Gson().fromJson(gson, Cart.class));
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "get")
	public List<Product> getCart(@RequestBody String gson) {
		return cartService.getCart(new Gson().fromJson(gson, String.class));
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "empty-cart")
	public void emptyCart(@RequestBody String gson) {
		System.out.println(gson);
		cartService.emptyCart(new Gson().fromJson(gson, String.class));
	}
}
