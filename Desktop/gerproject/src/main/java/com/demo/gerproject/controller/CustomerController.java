package com.demo.gerproject.controller;
import com.demo.gerproject.model.Customer;
import com.demo.gerproject.service.CustomerService;

import lombok.AllArgsConstructor;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

	private final CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<List<Customer>> getCustomers(){
		return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
		return new ResponseEntity<>(getCustomerById(id), HttpStatus.OK);
	}

	private Customer getCustomerById(int id) {
		return customerService.getCustomerById(id);
	}
	
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> getCustomer(@PathVariable int id, @RequestBody Customer customer){
		Customer oldCustomer = getCustomerById(id);
		oldCustomer.setFirstname(customer.getFirstname());
		oldCustomer.setLastname(customer.getLastname());
		oldCustomer.setPassword(customer.getPassword());
		oldCustomer.setCreatedAt(new Date());
		customerService.updateCustomer(id, oldCustomer);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable int id){
		customerService.deleteCustomer(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
