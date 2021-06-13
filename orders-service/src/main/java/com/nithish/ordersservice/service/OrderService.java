package com.nithish.ordersservice.service;

import java.util.*;

import com.nithish.ordersservice.entity.Address;
import com.nithish.ordersservice.entity.Cart;
import com.nithish.ordersservice.entity.Order;

public interface OrderService {
	
	List<Order> getAllOrders();
	
	Object placeOrder(Cart cart);
	
	void deleteOrder(String orderId);
	
	List<Order> getOrderByCustomerId(Integer customerId);

	String changeStatus(String orderId);

	
	

}
