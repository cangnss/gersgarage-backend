package com.demo.gerproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.gerproject.model.Place;
import com.demo.gerproject.model.Schedule;
import com.demo.gerproject.repository.ScheduleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ScheduleService {
	private final ScheduleRepository scheduleRepository;

	public List<Schedule> getSchedules() {
		return scheduleRepository.findAll();
	}
}
