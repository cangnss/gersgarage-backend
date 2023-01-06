package com.demo.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.demo.gerproject.model.Customer;
import com.demo.gerproject.service.CustomerService;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class UserDao {
	
	private final CustomerService customerService;
	private List<Customer> customers;
	
	public UserDetails findUserByEmail(String email) {
		customers = customerService.getCustomers();
		return (UserDetails) customers
				.stream()
				.filter(u -> u.getUsername().equals(email))
				.findFirst()
				.orElseThrow(() -> new UsernameNotFoundException("No user was found"));
	}
}
