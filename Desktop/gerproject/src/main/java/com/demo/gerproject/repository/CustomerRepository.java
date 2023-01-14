package com.demo.gerproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.gerproject.dao.UserVehiclesInServiceProjection;
import com.demo.gerproject.dao.VehiclesInServiceProjection;
import com.demo.gerproject.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	Optional<Customer> findByEmail(String email);
	
	@Query(value="select schedule.id, brand, model, km, description, bk_date, type, vehicle_status from schedule inner join customer on customer.id = schedule.customer_id inner join vehicle on schedule.vehicle_id = vehicle.id inner join place_service on schedule.place_service_type = place_service.id where customer.id = :id", nativeQuery=true)
	List<UserVehiclesInServiceProjection> getUserVehiclesInService(@PathVariable int id);
}
