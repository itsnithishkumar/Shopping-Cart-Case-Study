package com.nithish.cartservice.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.nithish.cartservice.entity.Cart;
import com.nithish.cartservice.repository.CartRepository;

public class CartServiceImplimentation implements CartService {
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public Optional<Cart> getCartById(String cartId) {
		
		return cartRepository.findById(cartId);
	}

	@Override
	public Cart updateCart(Cart cart) {
		
		return cartRepository.save(cart);
	}

	@Override
	public List<Cart> getAllCarts() {
		
		return cartRepository.findAll();
	}

	@Override
	public Cart addCart(Cart cart) {
		
		return cartRepository.save(cart);
	}

	@Override
	public BigDecimal cartTotal(Cart cart) {
		
		return cart.getTotalPrice();
	}
	
	

}
