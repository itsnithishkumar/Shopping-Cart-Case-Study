package com.nithish.cartservice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nithish.cartservice.entity.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart,String> {

	Cart findBycartId(String cartId);

}