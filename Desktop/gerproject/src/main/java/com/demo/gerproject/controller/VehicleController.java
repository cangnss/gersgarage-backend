package com.demo.gerproject.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.gerproject.model.Vehicle;
import com.demo.gerproject.service.VehicleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/vehicles")
@AllArgsConstructor
public class VehicleController {
	private final VehicleService vehicleService;

	@GetMapping
	public ResponseEntity<List<Vehicle>> getVehicles() {
		return new ResponseEntity<>(vehicleService.getVehicles(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Vehicle> getVehicle(@PathVariable int id) {
		return new ResponseEntity<>(getVehicleById(id), HttpStatus.OK);
	}

	private Vehicle getVehicleById(int id) {
		return vehicleService.getVehicleById(id);
	}

	@PostMapping
	public ResponseEntity<Vehicle> createCustomer(@RequestBody Vehicle vehicle) {
		return new ResponseEntity<>(vehicleService.createVehicle(vehicle), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> getVehicle(@PathVariable int id, @RequestBody Vehicle vehicle) {
		Vehicle oldVehicle = getVehicleById(id);
		oldVehicle.setVehicleType(vehicle.getVehicleType());
		oldVehicle.setVehicleEngineType(vehicle.getVehicleEngineType());
		oldVehicle.setBrand(vehicle.getBrand());
		oldVehicle.setKm(vehicle.getKm());
		oldVehicle.setV_year(vehicle.getV_year());
		oldVehicle.setModel(vehicle.getModel());
		vehicleService.updateVehicle(id, oldVehicle);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVehicle(@PathVariable int id) {
		vehicleService.deleteVehicle(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
