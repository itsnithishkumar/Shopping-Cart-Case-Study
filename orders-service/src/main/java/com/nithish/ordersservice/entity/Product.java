package com.nithish.ordersservice.entity;

public class Product {
	
	private int productId;
	private String productName;
	public Product() {
		super();
		
	}
	public Product(int productId, String productName) {
		super();
		this.productId = productId;
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + "]";
	}
	
	

}
