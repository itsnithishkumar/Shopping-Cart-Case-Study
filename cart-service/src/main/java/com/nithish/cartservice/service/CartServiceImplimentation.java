package com.nithish.cartservice.service;



import org.springframework.beans.factory.annotation.Autowired;

import com.nithish.cartservice.entity.Cart;
import com.nithish.cartservice.repository.CartRepository;


public class CartServiceImplimentation implements CartService {
	
	@Autowired
	CartRepository cartRepository;

	@Override
	public Cart findBycartId(String cartId) {
		
		return cartRepository.findBycartId(cartId);
	}

	@Override
	public Cart addItemToCart(Cart cart) {
		
		return cartRepository.save(cart);
	}

	@Override
	public Cart updateCart(Cart cart) {
		
		return cartRepository.save(cart);
	}

	@Override
	public Cart deleteItemFromCart(Cart cart) {
		
		return cartRepository.save(cart);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//rainbow
	/*
	 * @Autowired private CartRepository cartRepository;
	 * 
	 * @Autowired ProductClient client;
	 * 
	 * @Override public void addItemToCart(String cartId, String productId, int
	 * quantity) { Product product = client.getProductById(productId); Items items =
	 * new Items(product, Cart.getSubTotalForItem(product,quantity),quantity);
	 * cartRepository.addItemToCart(cartId, items); }
	 * 
	 * @Override public Cart getCart(String cartId) { return
	 * cartRepository.getCart(cartId); }
	 * 
	 * @Override public void changeItemQuantity(String cartId, String productId, int
	 * quantity) { List<Items> cart = (List)cartRepository.getCart(cartId);
	 * for(Items items : cart){
	 * if((items.getProduct().getProductId()).equals(productId)){
	 * cartRepository.deleteItemFromCart(cartId, items);
	 * items.setQuantity(quantity);
	 * items.setSubTotal(Cart.getSubTotalForItem(items.getProduct(),quantity));
	 * cartRepository.addItemToCart(cartId, items); } } }
	 * 
	 * @Override public void deleteItemFromCart(String cartId, String productId) {
	 * List<Items> cart = (List) cartRepository.getCart(cartId); for(Items items :
	 * cart){ if((items.getProduct().getProductId()).equals(productId)){
	 * cartRepository.deleteItemFromCart(cartId, items); } } }
	 * 
	 * @Override public boolean checkIfItemIsExist(String cartId, String productId)
	 * { List<Items> cart = (List) cartRepository.getCart(cartId); for(Items items :
	 * cart){ if((items.getProduct().getProductId()).equals(productId)){ return
	 * true; } } return false; }
	 * 
	 * @Override public List<Items> getAllItemsFromCart(String cartId) { List<Items>
	 * items = (List)cartRepository.getCart(cartId); return items; }
	 * 
	 * @Override public void deleteCart(String cartId) {
	 * cartRepository.deleteById(cartId); }
	 */
	
	
	
	
	
	
	//own
	
	/*
	 * @Override public Optional<Cart> getCartById(String cartId) {
	 * 
	 * return cartRepository.findById(cartId); }
	 * 
	 * @Override public Cart updateCart(Cart cart) {
	 * 
	 * return cartRepository.save(cart); }
	 * 
	 * @Override public List<Cart> getAllCarts() {
	 * 
	 * return cartRepository.findAll(); }
	 * 
	 * @Override public Cart addCart(Cart cart) {
	 * 
	 * return cartRepository.save(cart); }
	 * 
	 * @Override public BigDecimal cartTotal(Cart cart) {
	 * 
	 * return cart.getTotalPrice(); }
	 */
	
	

}
