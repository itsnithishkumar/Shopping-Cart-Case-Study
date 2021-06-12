package com.nithish.cartservice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nithish.cartservice.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping ("/mycart/{cartId}")
	@ResponseStatus(HttpStatus.OK)
    public List<Object> getCart(@PathVariable String cartId){
		
        List<Object> cart = cartService.getCart(cartId);
        return cart;
      
	}
	
	@PostMapping(value = "/addCart", params = {"productId", "quantity", "productName"})
	@ResponseStatus(HttpStatus.ACCEPTED)
    public void addItemToCart(
            @RequestParam("productId") int productId,
            @RequestParam("quantity") Integer quantity,
            @RequestParam("productName") String productName,
            @RequestHeader(value = "Cookie") String cartId,
            HttpServletRequest request) {
        List<Object> cart = cartService.getCart(cartId);
        if(cart != null) {
        	if(cart.isEmpty()){
        		cartService.addItemToCart(cartId, productId, quantity, productName);
        	}else{
        		if(cartService.checkIfItemIsExist(cartId, productId)){
        			cartService.changeItemQuantity(cartId, productId, quantity);
        		}else {
        			 cartService.addItemToCart(cartId, productId, quantity, productName);
        		}
        	}
        }
        	
        
    }

    @DeleteMapping(value = "/deleteCart", params = "productId")
    @ResponseStatus(HttpStatus.GONE)
    public void removeItemFromCart(
            @RequestParam("productId") int productId,
            @RequestHeader(value = "Cookie") String cartId){
    	List<Object> cart = cartService.getCart(cartId);
    	if(cart != null) {
    		cartService.deleteItemFromCart(cartId, productId);
    	}
    	else {
    		return;
    	}
    }
	
	

}
