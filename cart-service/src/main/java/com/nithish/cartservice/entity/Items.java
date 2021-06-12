package com.nithish.cartservice.entity;

import java.math.BigDecimal;

public class Items {
	
	private String productName;
	private int quantity;
	private BigDecimal subTotal;
	private Product product;
	
	public Items() {
		
	}
	public Items(String productName, int quantity, BigDecimal subTotal, Product product) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.subTotal = subTotal;
		this.product = product;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	

}
