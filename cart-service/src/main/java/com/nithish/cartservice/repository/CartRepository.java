package com.nithish.cartservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nithish.cartservice.entity.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart,String> {

	Optional<Cart> findById(String cartId);

}
