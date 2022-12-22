package com.demo.gerproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.gerproject.model.Customer;
import com.demo.gerproject.service.CustomerService;
import com.demo.gerproject.service.ServiceService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/services")
@AllArgsConstructor
public class ServiceController {
	private final ServiceService serviceService;
		
	@GetMapping
	public ResponseEntity<List<Service>> getServices(){
		return new ResponseEntity<>(serviceService.getServices(), HttpStatus.OK);
	}
}
