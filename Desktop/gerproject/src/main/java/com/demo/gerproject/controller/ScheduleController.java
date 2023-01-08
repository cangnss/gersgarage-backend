package com.demo.gerproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.gerproject.model.Schedule;
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
}
