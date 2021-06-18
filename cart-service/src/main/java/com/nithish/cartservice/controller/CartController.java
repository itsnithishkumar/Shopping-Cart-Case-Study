package com.nithish.cartservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nithish.cartservice.entity.Cart;
import com.nithish.cartservice.entity.Items;
import com.nithish.cartservice.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
    @PostMapping("/additem")
    public ResponseEntity<?> addItemToCart(@RequestBody Items item,
                                           @RequestParam String cartId){
        try{

            Cart cart = cartService.findbycartId(cartId);

            if(cart!=null){
                List<Items> items = cart.getItems();
                items.add(item);
                cart.setItems(items);
                cart.setCartTotal(cart.getCartTotal() + item.getProduct().getPrice()*item.getQuantity());
            }else{
                List<Items> items = new ArrayList<>();
                items.add(item);

                cart = new Cart();
                cart.setCartId(cartId);
                cart.setItems(items);
                cart.setCartTotal(item.getProduct().getPrice()*item.getQuantity());
            }

            Cart updatedCart = cartService.addItemToCart(cart);

            return  new ResponseEntity<>(updatedCart,HttpStatus.CREATED);

        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Get Cart By User Id

    @GetMapping("/getcart")
    public ResponseEntity<?> getCartByUserId(@RequestParam String cartId){
        try{
            Cart cart = this.cartService.findbycartId(cartId);
            if(cart != null){
                return new ResponseEntity<>(cart,HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Cart is empty",HttpStatus.OK);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Update Item in Cart

    @PutMapping("/updateitem")
    public ResponseEntity<?> updateItemInCart(@RequestBody Items item,
                                              @RequestParam String cartId){
        try{

            Cart cart = cartService.findbycartId(cartId);
            List<Items> items = cart.getItems();

            Items previousItem = new Items();



            for (Items value : items) {
                if (value.getProduct().getProductId().equals(item.getProduct().getProductId())) {

                    previousItem.getProduct().setProductId(value.getProduct().getProductId());
                    previousItem.getProduct().setPrice(value.getProduct().getPrice());
                    previousItem.setQuantity(value.getQuantity());

                    value.getProduct().setPrice(item.getProduct().getPrice());
                    value.setQuantity(item.getQuantity());
                    break;

                }
            }

            cart.setItems(items);

            double price = cart.getCartTotal()
                    - (previousItem.getProduct().getPrice()*previousItem.getQuantity())
                    + (item.getProduct().getPrice()*item.getQuantity());

            cart.setCartTotal(price);
            Cart updatedCart  = cartService.updateCart(cart);

            return  new ResponseEntity<>(updatedCart,HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Delete Item from Cart

    @DeleteMapping("/deleteitem")
    public ResponseEntity<?> deleteItemFromCart(@RequestBody Items item,
                                                @RequestParam String cartId
                                                ){
        try{
            Cart cart = this.cartService.findbycartId(cartId);
            List<Items> items = cart.getItems();

//          items.removeIf(x->x.getProductId().equals(productId));


            items.remove(item);
            cart.setItems(items);
            cart.setCartTotal(cart.getCartTotal()-item.getProduct().getPrice()*item.getQuantity());

            Cart cartAfterDeleted = this.cartService.deleteItemFromCart(cart);

            return new ResponseEntity<>(cartAfterDeleted,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deletecart")
    public ResponseEntity<?> deleteCart(@RequestParam String cartId){
        try{
            Cart cart = this.cartService.findbycartId(cartId);
            cart.setCartTotal(0);
            List<Items> items = new ArrayList<>();
            cart.setItems(items);
            cartService.updateCart(cart);
            return new ResponseEntity<>(cart,HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//rainbow
	/*
	 * @GetMapping ("/{cartId}") public Cart getCart(@PathVariable String cartId){
	 * 
	 * return cartRepository.getCart(cartId);
	 * 
	 * }
	 * 
	 * @PostMapping(value = "/cart", params = {"productId", "quantity"}) public
	 * List<Object> addItemToCart(
	 * 
	 * @RequestParam("productId") String productId,
	 * 
	 * @RequestParam("quantity") int quantity,
	 * 
	 * @RequestHeader(value = "Cookie") String cartId, HttpServletRequest request) {
	 * Cart cart = cartRepository.getCart(cartId); if(cart != null) {
	 * if(cart.isEmpty()){ cartRepository.addItemToCart(cartId, productId,
	 * quantity); }else{ if(cartRepository.checkIfItemIsExist(cartId, productId)){
	 * cartRepository.changeItemQuantity(cartId, productId, quantity); }else {
	 * cartRepository.addItemToCart(cartId, productId, quantity); } } return new
	 * ResponseEntity<List<Object>>( cart,
	 * headerGenerator.getHeadersForSuccessPostMethod(request,
	 * Long.parseLong(cartId)), HttpStatus.CREATED); } }
	 * 
	 * @DeleteMapping(value = "/cart", params = "productId") public void
	 * removeItemFromCart(
	 * 
	 * @RequestParam("productId") String productId,String cartId){ Cart cart =
	 * cartRepository.getCart(cartId); if(cart != null) {
	 * cartRepository.deleteItemFromCart(cartId, productId); } }
	 */
	
	
	
	
	
	
	
	
//own 	
	
	/*
	 * @GetMapping("/allcarts") public List<Cart> getAllCarts() {
	 * 
	 * return cartRepository.findAll();
	 * 
	 * }
	 * 
	 * @GetMapping("/{cartId}") public Optional<Cart> getCartById(@PathVariable
	 * String cartId) {
	 * 
	 * return cartRepository.findById(cartId);
	 * 
	 * }
	 * 
	 * @PostMapping("/addcart") public Cart addCart(Cart cart) {
	 * 
	 * return cartRepository.save(cart);
	 * 
	 * }
	 * 
	 * @PutMapping("/updatecart") public Cart updateCart(Cart cart) {
	 * 
	 * return cartRepository.save(cart);
	 * 
	 * }
	 */

}
