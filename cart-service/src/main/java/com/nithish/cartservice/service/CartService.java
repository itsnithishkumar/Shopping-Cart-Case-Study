package com.nithish.cartservice.service;

import java.util.List;

import com.nithish.cartservice.entity.Items;


public interface CartService {
	
	public void addItemToCart(String cartId, int productId, Integer quantity, String productName);
    public List<Object> getCart(String cartId);
    public void changeItemQuantity(String cartId, int productId, Integer quantity);
    public void deleteItemFromCart(String cartId, int productId);
    public boolean checkIfItemIsExist(String cartId, int productId);
    public List<Items> getAllItemsFromCart(String cartId);
    public void deleteCart(String cartId);

	
}
