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

import com.demo.gerproject.model.Customer;
import com.demo.gerproject.model.Place;
import com.demo.gerproject.service.CustomerService;
import com.demo.gerproject.service.PlaceService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/places")
@AllArgsConstructor
public class PlaceController {
	private final PlaceService placeService;

	@GetMapping
	public ResponseEntity<List<Place>> getPlaces() {
		return new ResponseEntity<>(placeService.getPlaces(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Place> getPlace(@PathVariable int id) {
		return new ResponseEntity<>(getPlaceById(id), HttpStatus.OK);
	}

	private Place getPlaceById(int id) {
		return placeService.getPlaceById(id);
	}

	@PostMapping
	public ResponseEntity<Place> createPlace(@RequestBody Place place) {
		return new ResponseEntity<>(placeService.createPlace(place), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> getPlace(@PathVariable int id, @RequestBody Place place) {
		Place oldPlace = getPlaceById(id);
		oldPlace.setName(place.getName());
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePlace(@PathVariable int id) {
		placeService.deletePlace(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
