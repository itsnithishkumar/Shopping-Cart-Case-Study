package com.nithish.cartservice.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nithish.cartservice.entity.Cart;
import com.nithish.cartservice.entity.Items;


public interface CartRepository {

	public void addItemToCart(String key, Object items);
    public Collection<Object> getCart(String key, Class type);
    public void deleteItemFromCart(String key, Object items);
    public void deleteCart(String key);


	

}
