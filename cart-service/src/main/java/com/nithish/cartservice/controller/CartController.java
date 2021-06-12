package com.nithish.cartservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nithish.cartservice.entity.Cart;
import com.nithish.cartservice.repository.CartRepository;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartRepository cartRepository;
	
	@GetMapping("/allcarts")
	public List<Cart> getAllCarts() {
		
		return cartRepository.findAll();
		
	}
	@GetMapping("/{cartId}")
	public Optional<Cart> getCartById(@PathVariable String cartId) {
		
		return cartRepository.findById(cartId);
		
	}
	@PostMapping("/addcart")
	public Cart addCart(Cart cart) {
		
		return cartRepository.save(cart);
		
	}
	@PutMapping("/updatecart")
	public Cart updateCart(Cart cart) {
			
		return cartRepository.save(cart);
		
	}

}
