package com.demo.gerproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.gerproject.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
