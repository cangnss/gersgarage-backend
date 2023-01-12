package com.demo.gerproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.gerproject.dao.VehiclesInServiceProjection;
import com.demo.gerproject.model.Customer;
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
	
	public Schedule addSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}
	
	public Schedule getScheduleById(int id) {
		return scheduleRepository.findById(id)
								.orElseThrow(() -> new RuntimeException("Schedule is not found!"));
	}
	
	public void updateSchedule(int id, Schedule newSchedule) {
		Schedule oldSchedule = getScheduleById(id);
		oldSchedule.setVehicleStatus(newSchedule.getVehicleStatus());
		scheduleRepository.save(oldSchedule);
    }
	
	public List<VehiclesInServiceProjection> getVehiclesInService(){
		return scheduleRepository.getVehiclesInService();
	}
	
}
