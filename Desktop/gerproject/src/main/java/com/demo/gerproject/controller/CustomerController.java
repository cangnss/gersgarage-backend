package com.demo.gerproject.controller;
import com.demo.gerproject.model.Customer;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@GetMapping
	public ResponseEntity<List<Customer>> getCustomers(){
		
		Customer c1 = new Customer(1, "Ali Can", "Gunes");
		Customer c2 = new Customer(2, "Dilek", "Yalcin");

		List<Customer> customers = Arrays.asList(c1, c2);
		
		
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
}
