package com.demo.gerproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.gerproject.dao.PaymentResponseProjection;
import com.demo.gerproject.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	
	@Query(value="select place_service.type, place_service.price from schedule inner join place_service on place_service.id = schedule.place_service_type where schedule.id = :id", nativeQuery=true)
	PaymentResponseProjection getPricePlaceService(int id);
}
