package com.demo.gerproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.gerproject.dao.PaymentResponseProjection;
import com.demo.gerproject.model.Payment;
import com.demo.gerproject.model.PaymentStatus;
import com.demo.gerproject.service.PaymentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
@CrossOrigin(origins="http://localhost:3000")
public class PaymentController {
	private final PaymentService paymentService;
	
	@GetMapping
	public ResponseEntity<List<Payment>> getPayments() {
		return new ResponseEntity<>(paymentService.getPayments(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> addPayment(@RequestBody Payment payment){
		List<Payment> allPayments = paymentService.getPayments();
		for (Payment p : allPayments) {
			if(p.getScheduleId() == payment.getScheduleId()) {
				if(p.getStatus().equals(PaymentStatus.PAID)) {
					return ResponseEntity.badRequest().body("Odeme yapilmistir");
				}
			}
		}
		paymentService.addPayment(payment);
		return ResponseEntity.ok().body("Yeni odeme eklenmistir");
	}
	
	@GetMapping("{id}")
	public ResponseEntity<PaymentResponseProjection> getPricePlaceService(@PathVariable int id){
		return new ResponseEntity<>(paymentService.getPricePlaceService(id), HttpStatus.OK);
	}
	
}
