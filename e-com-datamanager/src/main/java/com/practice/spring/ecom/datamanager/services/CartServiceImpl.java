package com.practice.spring.ecom.datamanager.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.spring.ecom.datamanager.models.Cart;
import com.practice.spring.ecom.datamanager.models.Product;
import com.practice.spring.ecom.datamanager.repositories.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	private CartRepository cartRepository;
	
	@Autowired
	public CartServiceImpl(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	@Override
	public Cart addToCart(Cart cart) {
		Cart newCart= cartRepository.save(cart);
		System.out.println(newCart);
		return newCart;
	}

	@Override
	@Transactional
	public void emptyCart(String email) {
		System.out.println(email);
		cartRepository.deleteByEmail(email);
	}

	@Transactional
	@Override
	public List<Product> getCart(String email) {
		List<String> productIds = cartRepository.findProductIdByEmail(email);	
		return cartRepository.findAllProductsById(productIds);
	}

}
