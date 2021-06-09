package com.nithish.profileservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="UserDetails")
public class UserDetails {
	
	@Id
	private String userId;
	private String password;
	private String firstName;
	private String lastName;
	private String role;
	private String emailId;
	private Long mobileNo;
	private Address address;

	public UserDetails() {

	}
	
	public UserDetails(String userId, String password, String firstName, String lastName, String role, String emailId,
			Long mobileNo, Address address) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.address = address;
	}

	public String getId() {
		return userId;
	}
	public void setId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", role=" + role + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", address="
				+ address + "]";
	}
	

	
	

}
