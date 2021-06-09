package com.nithish.profileservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nithish.profileservice.entity.UserDetails;

@Repository
public interface UserDetailsRepository extends MongoRepository<UserDetails,String> {

	UserDetails findByMobileNo(Long mobileNo);

	UserDetails findByFirstName(String firstName);

	UserDetails deleteByUserId(String userId);
	
	
}
