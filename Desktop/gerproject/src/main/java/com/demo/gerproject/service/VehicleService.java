package com.demo.gerproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.gerproject.model.Customer;
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
	
	public void updateVehicle(int id, Vehicle newVehicle) {
		Vehicle oldVehicle = getVehicleById(id);
		oldVehicle.setVehicleType(newVehicle.getVehicleType());
		oldVehicle.setBrand(newVehicle.getBrand());
		oldVehicle.setKm(newVehicle.getKm());
		oldVehicle.setModel(newVehicle.getModel());
		oldVehicle.setV_year(newVehicle.getV_year());
		oldVehicle.setVehicleEngineType(newVehicle.getVehicleEngineType());
        vehicleRepository.save(oldVehicle);
    }
}
