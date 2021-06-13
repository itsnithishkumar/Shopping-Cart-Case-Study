package com.nithish.ordersservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.data.mongodb.core.query.Update;

import com.nithish.ordersservice.entity.Cart;
import com.nithish.ordersservice.entity.Order;
import com.nithish.ordersservice.repository.OrderRepository;

public class OrderServiceImplimentation implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	MongoOperations mongoOperations;

	@Override
	public List<Order> getAllOrders() {
		
		return orderRepository.findAll();
	}

	@Override
	public Object placeOrder(Cart cart) {
		
		return orderRepository.save(cart);
	}

	@Override
	public void deleteOrder(String orderId) {
		
		orderRepository.deleteById(orderId);
	}

	@Override
	public List<Order> getOrderByCustomerId(Integer customerId) {

		return orderRepository.findByCustomerId(customerId);
	}

	@Override
	public String changeStatus(String orderId) {
		
		  Order order1=mongoOperations.findOne(query(where("orderId").is(orderId)),Order.class); 
		  mongoOperations.updateFirst(query(where("OrderId").is(1001)),
		  Update.update("orderStatus", "Order Placed"), Order.class);
		
		return "Order Status is updated";
	}


}
