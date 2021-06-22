package com.nithish.productservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nithish.productservice.entity.Product;
import com.nithish.productservice.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired 
	private ProductRepository productRepository;
	
	@GetMapping("/allproducts")
	public List<Product> getAllProducts(){
		
		return productRepository.findAll();
	}
	@GetMapping("/{prodcutId}")
	public Optional<Product> getProductById(@PathVariable String productId) {
		
		return productRepository.findById(productId);
	}
	@GetMapping("/productname/{productName}")
	public List<Product> getProductByName(@PathVariable String productName) {
		
		return productRepository.findByProductName(productName);
	}
	@GetMapping("/category/{category}")
	public List<Product> getProductByCategory(@PathVariable String category){
		
		return productRepository.findByCategory(category);
	}
	@PostMapping("/admin/addProduct")
	public String addProduct(@RequestBody Product product) {
		
		productRepository.save(product);
		return "A new product is added";
	}
	@PutMapping("/admin/updateproduct")
	public String updateProduct(Product product) {
		
		productRepository.save(product);
		return "A existing product is updated";
	}
	@DeleteMapping("/admin/deleteproduct/{productId}")
	public String deleteProductByProductId(@PathVariable String productId) {
		
		productRepository.deleteByProductId(productId);
		return "Product Deleted with a Product Id " + productId;
	}

}
