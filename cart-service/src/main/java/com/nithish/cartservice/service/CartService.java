package com.nithish.cartservice.service;



import com.nithish.cartservice.entity.Cart;

public interface CartService {
	
	Cart findBycartId(String cartId);

    Cart addItemToCart(Cart cart);

    Cart updateCart(Cart cart);

    Cart deleteItemFromCart(Cart cart);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//rainbow
	/*
	 * public void addItemToCart(String cartId, String productId, int quantity);
	 * 
	 * public Cart getCart(String cartId);
	 * 
	 * public void changeItemQuantity(String cartId, String productId, int
	 * quantity);
	 * 
	 * public void deleteItemFromCart(String cartId, String productId);
	 * 
	 * public List<Items> getAllItemsFromCart(String cartId);
	 * 
	 * public void deleteCart(String cartId);
	 * 
	 * boolean checkIfItemIsExist(String cartId, String productId);
	 */

}
