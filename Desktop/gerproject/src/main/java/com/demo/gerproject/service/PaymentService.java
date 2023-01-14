package com.demo.gerproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.gerproject.dao.PaymentResponseProjection;
import com.demo.gerproject.model.Customer;
import com.demo.gerproject.model.Employee;
import com.demo.gerproject.model.Payment;
import com.demo.gerproject.model.PaymentStatus;
import com.demo.gerproject.repository.PaymentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentService {
	private final PaymentRepository paymentRepository;

	public List<Payment> getPayments() {
		return paymentRepository.findAll();
	}
	
	public boolean addPayment(Payment payment) {
		paymentRepository.save(payment);
		return true;
	}
	
	public PaymentResponseProjection getPricePlaceService(int id) {
		return paymentRepository.getPricePlaceService(id);
	}

}
