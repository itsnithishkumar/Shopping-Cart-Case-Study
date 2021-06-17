package com.nithish.ordersservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nithish.ordersservice.entity.Order;
import com.nithish.ordersservice.repository.OrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/allorders")
	public List<Order> getAllOrders() {
		
		return orderRepository.findAll();
	}
	@PutMapping("/placeorder")
	public Order placeOrder(Order order) {
		
		return orderRepository.save(order);
	}
	@DeleteMapping("/deleteorder/{orderId}")
	public void deleteOrder(@PathVariable String orderId) {
		
		orderRepository.deleteById(orderId);
	}
	@GetMapping("/{customerId}")
	public List<Order> getOrderByCustomerId(@PathVariable String orderId) {

		return orderRepository.findByOrderId(orderId);
	}
	
	
	

}
