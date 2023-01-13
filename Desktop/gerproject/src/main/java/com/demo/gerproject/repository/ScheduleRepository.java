package com.demo.gerproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.gerproject.dao.UserCommentProjection;
import com.demo.gerproject.dao.VehiclesInServiceProjection;
import com.demo.gerproject.model.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{
	
	@Query(value="select s.id, c.firstname, c.lastname, v.brand, v.model, v.km, s.bk_date, s.vehicle_status from schedule as s inner join customer as c on c.id = s.customer_id inner join vehicle as v on s.vehicle_id = v.id", nativeQuery=true)
	List<VehiclesInServiceProjection> getVehiclesInService();
}
