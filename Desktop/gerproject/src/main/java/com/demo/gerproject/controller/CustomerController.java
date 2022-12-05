package com.demo.gerproject.controller;
import com.demo.gerproject.model.Customer;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private static final List<Customer> customers = new ArrayList<>();
	
	public CustomerController() {

		Customer c1 = new Customer(1, "Ali Can", "Gunes", new Date());
		Customer c2 = new Customer(2, "Dilek", "Yalcin", new Date());

		customers.add(c1);
		customers.add(c2);
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> getCustomers(){
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
		Customer result = customers.stream()
				 .filter(customer -> customer.getId() == id)
				 .findFirst()
				 .orElseThrow(() -> new RuntimeException("Customer is not found!"));
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		customer.setCreateDate(new Date());
		customers.add(customer);
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}
}
