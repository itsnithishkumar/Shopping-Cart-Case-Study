package com.nithish.ordersservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nithish.ordersservice.entity.Order;
import com.nithish.ordersservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/add-order")
    public ResponseEntity<?> addOrder(@RequestBody Order order){
        try{
            orderService.addOrder(order);
            return new ResponseEntity<>("Order Success",HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-order-by-order-id")
    public ResponseEntity<?> getOrderByUserId(@RequestParam String orderId){
        try{
            List<Order> order = orderService.findByOrderId(orderId);
            return  new ResponseEntity<>(order,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update-order")
    public ResponseEntity<?> updateOrder(@RequestBody Order order){
        try{
            orderService.addOrder(order);
            return new ResponseEntity<>(order,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * @GetMapping("/allorders") public List<Order> getAllOrders() {
	 * 
	 * return orderRepository.findAll(); }
	 * 
	 * @PutMapping("/placeorder") public Order placeOrder(Order order) {
	 * 
	 * return orderRepository.save(order); }
	 * 
	 * @DeleteMapping("/deleteorder/{orderId}") public void
	 * deleteOrder(@PathVariable String orderId) {
	 * 
	 * orderRepository.deleteById(orderId); }
	 * 
	 * @GetMapping("/{customerId}") public List<Order>
	 * getOrderByCustomerId(@PathVariable String orderId) {
	 * 
	 * return orderRepository.findByOrderId(orderId); }
	 */
	
	
	


