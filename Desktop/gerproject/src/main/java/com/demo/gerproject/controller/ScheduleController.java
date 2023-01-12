package com.demo.gerproject.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.gerproject.dao.VehiclesInServiceProjection;
import com.demo.gerproject.model.Customer;
import com.demo.gerproject.model.Schedule;
import com.demo.gerproject.model.VehicleStatus;
import com.demo.gerproject.service.ScheduleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/schedules")
@AllArgsConstructor
@CrossOrigin(origins="http://localhost:3000")
public class ScheduleController {
	private final ScheduleService scheduleService;
	
	@GetMapping
	public ResponseEntity<List<Schedule>> getSchedules() {
		return new ResponseEntity<>(scheduleService.getSchedules(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Schedule> addSchedule(@RequestBody Schedule schedule){
		int available = 4;
		schedule.setAvailable(available);
		schedule.setVehicleStatus(VehicleStatus.BOOKED);
		
		List<Schedule> schedules = scheduleService.getSchedules();
		
		for (Schedule sc : schedules) {
			if (sc.getBkDate().getDay() == schedule.getBkDate().getDay() && sc.getBkDate().getMonth() == schedule.getBkDate().getMonth() && sc.getBkDate().getYear() == schedule.getBkDate().getYear()) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		}
		
		return new ResponseEntity<Schedule>(scheduleService.addSchedule(schedule), HttpStatus.OK);
	}
	
	private Schedule getScheduleById(int id) {
		return scheduleService.getScheduleById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> getSchedule(@PathVariable int id, @RequestBody Schedule schedule){
		Schedule oldSchedule = getScheduleById(id);
		oldSchedule.setVehicleStatus(schedule.getVehicleStatus());
		scheduleService.updateSchedule(id, oldSchedule);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@GetMapping("/activeVehicles")
	public ResponseEntity<List<VehiclesInServiceProjection>> getVehiclesInService(){
		return new ResponseEntity<>(scheduleService.getVehiclesInService(), HttpStatus.OK);
	}
}
