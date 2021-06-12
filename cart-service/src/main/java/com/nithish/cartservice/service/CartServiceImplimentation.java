package com.nithish.cartservice.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nithish.cartservice.entity.Cart;
import com.nithish.cartservice.entity.Items;
import com.nithish.cartservice.entity.Product;
import com.nithish.cartservice.repository.CartRepository;
import com.nithish.cartservice.utilities.CartUtilities;

public class CartServiceImplimentation implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	
	public void addItemToCart(String cartId, int productId, Integer quantity, String productName) {
        Product product = productClient.getProductById(productId);
        Items item = new Items(productName, quantity,CartUtilities.getSubTotalForItem(product,quantity),product);
        cartRepository.addItemToCart(cartId, item);
    }

    
    public List<Object> getCart(String cartId) {
        return (List<Object>)cartRepository.getCart(cartId, Items.class);
    }

    
    public void changeItemQuantity(String cartId, int productId, Integer quantity) {
        List<Items> cart = (List)cartRepository.getCart(cartId, Items.class);
        for(Items items : cart){
            if((items.getProduct().getProductId())==(productId)){
                cartRepository.deleteItemFromCart(cartId, items);
                items.setQuantity(quantity);
                items.setSubTotal(CartUtilities.getSubTotalForItem(items.getProduct(),quantity));
                cartRepository.addItemToCart(cartId, items);
            }
        }
    }

    
    public void deleteItemFromCart(String cartId, int productId) {
        List<Items> cart = (List) cartRepository.getCart(cartId, Items.class);
        for(Items items : cart){
            if((items.getProduct().getProductId())==(productId)){
                cartRepository.deleteItemFromCart(cartId, items);
            }
        }
    }

    
    public boolean checkIfItemIsExist(String cartId, int productId) {
        List<Items> cart = (List) cartRepository.getCart(cartId, Items.class);
        for(Items items : cart){
            if((items.getProduct().getProductId())==(productId)){
                return true;
            }
        }
        return false;
    }


	@Override
	public List<Items> getAllItemsFromCart(String cartId) {

		return null;
	}


	@Override
	public void deleteCart(String cartId) {

		
	}

   
    
	
	
	
	
	
	
}
