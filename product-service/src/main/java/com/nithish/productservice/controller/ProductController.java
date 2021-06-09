package com.nithish.productservice.controller;

import java.util.List;

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
	@GetMapping("/{productName}")
	public List<Product> getProductByName(@PathVariable String productName) {
		
		return productRepository.findByProductName(productName);
	}
	@GetMapping("/{category}")
	public List<Product> getProductByCategory(@PathVariable String category){
		
		return productRepository.findByCategory(category);
	}
	@GetMapping
	public List<Product> getProductByType(String productType){
		
		return productRepository.findByProductType(productType);
	}
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product) {
		
		productRepository.save(product);
		return "A new product is added";
	}
	@PutMapping("/updateproduct")
	public String updateProduct(Product product) {
		
		productRepository.save(product);
		return "A existing product is updated";
	}
	@DeleteMapping("/deleteproduct/{productId}")
	public String deleteProductByProductId(@PathVariable int productId) {
		
		productRepository.deleteByProductId(productId);
		return "Product Deleted with a Product Id " + productId;
	}

}
