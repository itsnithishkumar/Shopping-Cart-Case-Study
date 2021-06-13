package com.nithish.ordersservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nithish.ordersservice.entity.Cart;
import com.nithish.ordersservice.entity.Order;
import com.nithish.ordersservice.repository.OrderRepository;
import com.nithish.ordersservice.service.OrderServiceImplimentation;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderServiceImplimentation orderServiceImplimentation;
	
	@GetMapping("/allorders")
	public List<Order> getAllOrders() {
		
		return orderRepository.findAll();
	}
	@PutMapping("/placeorder")
	public Object placeOrder(Cart cart) {
		
		return orderRepository.save(cart);
	}
	@DeleteMapping("/deleteorder/{orderId}")
	public void deleteOrder(@PathVariable String orderId) {
		
		orderRepository.deleteById(orderId);
	}
	@GetMapping("/{customerId}")
	public List<Order> getOrderByCustomerId(@PathVariable Integer customerId) {

		return orderRepository.findByCustomerId(customerId);
	}
	@PutMapping("/changeStatus/{orderId} ")
	public String changeStatus(@PathVariable String orderId) {
		
		  orderServiceImplimentation.changeStatus(orderId);
		return "Order Status is updated";
	}
	
	
	

}
