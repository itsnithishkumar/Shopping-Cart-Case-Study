package com.nithish.profileservice.service;

import java.util.List;
import java.util.Optional;

import com.nithish.profileservice.entity.UserDetails;

public interface ProfileService {

	Optional<UserDetails> getByUserId(String userId);

	List<UserDetails> getAllProfiles();
	
	UserDetails addNewCustomerProfile(UserDetails userDetails);
	
	UserDetails addAdminProfile(UserDetails userDetails);

	UserDetails getByFirstName(String firstName);

	UserDetails updateProfile(UserDetails userDetails);

	UserDetails deleteUserById(String userId);

	
	
	
	

}
