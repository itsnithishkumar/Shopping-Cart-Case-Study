package com.nithish.ordersservice.service;

import java.util.*;

import com.nithish.ordersservice.entity.Address;
import com.nithish.ordersservice.entity.Cart;
import com.nithish.ordersservice.entity.Order;

public interface OrderService {
	
	List<Order> getAllOrders();
	
	Order placeOrder(Order order);
	
	void deleteOrder(String orderId);
	
	List<Order> getOrderByOrderId(String orderId);

}
