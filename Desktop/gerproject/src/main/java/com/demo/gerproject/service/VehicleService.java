package com.demo.gerproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.gerproject.model.Place;
import com.demo.gerproject.model.Vehicle;
import com.demo.gerproject.repository.PlaceRepository;
import com.demo.gerproject.repository.VehicleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VehicleService {
	private final VehicleRepository vehicleRepository;

	public List<Vehicle> getVehicles() {
		return vehicleRepository.findAll();
	}

	public Vehicle createVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	public void deleteVehicle(int id) {
		vehicleRepository.deleteById(id);
	}

	public Vehicle getVehicleById(int id) {
		return vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Place is not found!"));
	}
}
