package com.nithish.productservice.service;

import java.util.List;

import com.nithish.productservice.entity.Product;

public interface ProductService {

	List<Product> getAllProducts();

	List<Product> getProductByName(String productName);

	List<Product> getProductByCategory(String category);

	List<Product> getProductByType(String productType);

	Product addProduct(Product product);

	Product updateProduct(Product product);

	Product deleteProductByProductId(String productId);

}
