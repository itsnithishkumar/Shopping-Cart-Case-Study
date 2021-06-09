package com.nithish.profileservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nithish.profileservice.entity.UserDetails;
import com.nithish.profileservice.repository.UserDetailsRepository;

@RestController
@RequestMapping("/profile-service")
public class ProfileController {
	
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@GetMapping("/allusers")
	@ResponseStatus(HttpStatus.OK)
	public List<UserDetails> getAllProfiles() {
		
		return userDetailsRepository.findAll();
	}
	@GetMapping("/allusers/{user_id}")
	@ResponseStatus(HttpStatus.FOUND)
	public Optional<UserDetails> getByUserId( @PathVariable String userId) {
		
		return userDetailsRepository.findById(userId);
	}
	@GetMapping("/allusers/{firstName}")
	@ResponseStatus(HttpStatus.FOUND)
	public UserDetails getByFirstName(@PathVariable String firstName) {
		
		return userDetailsRepository.findByFirstName(firstName);
	}
	@PutMapping("/update/{user_id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public UserDetails updateProfile(@RequestBody UserDetails userDetails, @PathVariable String user_id) {
		
		userDetails.setId(user_id);
		userDetailsRepository.save(userDetails);
		return userDetails;
	}
	@PostMapping("/customerRegistration")
	public String addNewCustomerProfile(@RequestBody UserDetails userDetails) {
		
		userDetailsRepository.save(userDetails);
		return "A new Customer is added";
	}
	@PostMapping("/addAdmin")
	public String addAdminProfile(@RequestBody UserDetails userDetails) {
		
		userDetailsRepository.save(userDetails);
		return "Admin Profile is added";
	}
	@DeleteMapping("/delete/{user_id}")
	public String deleteUserById(@PathVariable String userId) {
		
		userDetailsRepository.deleteByUserId(userId);
		return "User Deleted with an Id: " + userId;
	}

}
