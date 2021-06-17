package com.nithish.productservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nithish.productservice.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	
	List<Product> findByProductName(String productName);
	
	List<Product> findByCategory(String category);
	
	List<Product> findByProductType(String productType);

	Product deleteByProductId(String productId);

}
