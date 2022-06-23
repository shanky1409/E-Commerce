package com.practice.spring.ecom.cart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.practice.spring.ecom.cart.models.Cart;
import com.practice.spring.ecom.cart.utils.RestClient;

@Service
public class CartServiceImpl implements CartService {

	private RestClient restClient;
	
	@Autowired
	public CartServiceImpl(RestClient restClient) {
		this.restClient = restClient;
	}

	@Override
	public Cart addTocart(Cart cart) {
		String response= restClient.post("/data/cart", new Gson().toJson(cart));
		return new Gson().fromJson(response, Cart.class);
	}

	@Override
	public void emptyCart(String email) {
		restClient.post("/data/cart/empty-cart", new Gson().toJson(email));
		//return new Gson().fromJson(response, Object.class);
	}

	@Override
	public Object getCartItems(String email) {
		String response= restClient.post("/data/cart/get", new Gson().toJson(email));
		return new Gson().fromJson(response, Object.class);
	}

	

}
