package com.nithish.profileservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.nithish.profileservice.entity.UserDetails;
import com.nithish.profileservice.repository.UserDetailsRepository;

public class ProfileServiceImplimentation implements ProfileService{
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	@Override
	public List<UserDetails> getAllProfiles() {
		
		return userDetailsRepository.findAll();
	}

	@Override
	public Optional<UserDetails> getByUserId(String userId) {
		
		return userDetailsRepository.findById(userId);
	}
	@Override
	public UserDetails getByFirstName(String firstName) {
		
		return userDetailsRepository.findByFirstName(firstName);
	}
	@Override
	public UserDetails updateProfile(UserDetails userDetails) {
		
		return userDetailsRepository.save(userDetails);
	}
	@Override
	public UserDetails addNewCustomerProfile(UserDetails userDetails) {
		return userDetailsRepository.save(userDetails);
	}
	@Override
	public UserDetails addAdminProfile(UserDetails userDetails) {
		return userDetailsRepository.save(userDetails);
	}
	@Override
	public UserDetails deleteUserById(String userId) {
		
		return userDetailsRepository.deleteByUserId(userId);
	}
	

}
