package com.nithish.ordersservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nithish.ordersservice.entity.Cart;
import com.nithish.ordersservice.entity.Order;


public interface OrderRepository extends MongoRepository<Order, String> {

	List<Order> findByCustomerId(Integer customerId);

	String changeStatusTo(String orderStatus, String orderId);

	Object save(Cart cart);
	

}
