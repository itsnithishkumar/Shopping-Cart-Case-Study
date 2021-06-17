package com.nithish.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nithish.productservice.entity.Product;
import com.nithish.productservice.repository.ProductRepository;

public class ProductServiceImplimentation implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Override
	public List<Product> getAllProducts(){
		
		return productRepository.findAll();
	}
	@Override
	public List<Product> getProductByName(String productName) {
		
		return productRepository.findByProductName(productName);
	}
	@Override
	public List<Product> getProductByCategory(String category){
		
		return productRepository.findByCategory(category);
	}
	@Override
	public List<Product> getProductByType(String productType){
		
		return productRepository.findByProductType(productType);
	}
	@Override
	public Product addProduct(Product product) {
		
		return productRepository.save(product);
	}
	@Override
	public Product updateProduct(Product product) {
		
		return productRepository.save(product);
	}
	
	@Override
	public Product deleteProductByProductId(String productId) {
		
		return productRepository.deleteByProductId(productId);
	}

}
