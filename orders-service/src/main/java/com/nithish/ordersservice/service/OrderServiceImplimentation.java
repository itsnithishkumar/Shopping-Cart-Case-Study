package com.nithish.ordersservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.nithish.ordersservice.entity.Order;
import com.nithish.ordersservice.repository.OrderRepository;

public class OrderServiceImplimentation implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
    public void addOrder(Order order) {
        this.orderRepository.save(order);
    }

    @Override
    public List<Order> findByOrderId(String orderId) {
        return this.orderRepository.findByOrderId(orderId);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * @Autowired MongoOperations mongoOperations;
	 * 
	 * @Override public List<Order> getAllOrders() {
	 * 
	 * return orderRepository.findAll(); }
	 * 
	 * @Override public Order placeOrder(Order order) {
	 * 
	 * return orderRepository.save(order); }
	 * 
	 * @Override public void deleteOrder(String orderId) {
	 * 
	 * orderRepository.deleteById(orderId); }
	 * 
	 * @Override public List<Order> getOrderByOrderId(String orderId) {
	 * 
	 * return orderRepository.findByOrderId(orderId); }
	 */

	


}
