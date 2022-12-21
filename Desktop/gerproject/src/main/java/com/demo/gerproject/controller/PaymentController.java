package com.demo.gerproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.gerproject.model.Payment;
import com.demo.gerproject.service.PaymentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
public class PaymentController {
	private final PaymentService paymentService;
	
	@GetMapping
	public ResponseEntity<List<Payment>> getPayments() {
		return new ResponseEntity<>(paymentService.getPayments(), HttpStatus.OK);
	}
	
}
