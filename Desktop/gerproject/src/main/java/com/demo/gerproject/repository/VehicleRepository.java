package com.demo.gerproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.gerproject.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
	
	@Query(value="select * from vehicle where customer_id = :id", nativeQuery=true)
	List<Vehicle> getUserVehicles(int id);
	// bring vehicles from customer by id
}
