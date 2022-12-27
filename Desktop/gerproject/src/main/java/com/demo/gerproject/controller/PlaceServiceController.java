package com.demo.gerproject.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.gerproject.model.Customer;
import com.demo.gerproject.model.Place;
import com.demo.gerproject.model.PlaceService;
import com.demo.gerproject.service.PlaceServiceService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/services")
@CrossOrigin
@AllArgsConstructor
public class PlaceServiceController {
	private final PlaceServiceService placeServiceService;
	
	@GetMapping
	public ResponseEntity<List<PlaceService>> getPlaceServices() {
		return new ResponseEntity<>(placeServiceService.getPlaceServices(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PlaceService> getPlaceService(@PathVariable int id) {
		return new ResponseEntity<>(getPlaceServiceById(id), HttpStatus.OK);
	}

	private PlaceService getPlaceServiceById(int id) {
		return placeServiceService.getPlaceServiceById(id);
	}
	
	@PostMapping
	public ResponseEntity<PlaceService> createPlaceService(@RequestBody PlaceService placeService){
		return new ResponseEntity<>(placeServiceService.createPlaceService(placeService), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> getPlaceService(@PathVariable int id, @RequestBody PlaceService placeService){
		PlaceService oldPlaceService = getPlaceServiceById(id);
		oldPlaceService.setType(placeService.getType());
		oldPlaceService.setPrice(placeService.getPrice());
		placeServiceService.updatePlaceService(id, oldPlaceService);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePlaceService(@PathVariable int id){
		placeServiceService.deletePlaceService(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
