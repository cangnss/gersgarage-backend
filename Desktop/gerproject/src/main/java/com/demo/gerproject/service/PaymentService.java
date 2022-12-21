package com.demo.gerproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.gerproject.model.Employee;
import com.demo.gerproject.model.Payment;
import com.demo.gerproject.repository.PaymentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentService {
	private final PaymentRepository paymentRepository;

	public List<Payment> getPayments() {
		return paymentRepository.findAll();
	}

}
