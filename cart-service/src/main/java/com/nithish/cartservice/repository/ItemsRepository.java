package com.nithish.cartservice.repository;

import org.springframework.stereotype.Repository;

import com.nithish.cartservice.entity.Items;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface ItemsRepository extends MongoRepository<Items, String> {

}
