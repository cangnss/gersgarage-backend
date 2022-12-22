package com.demo.gerproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.gerproject.model.Place;
import com.demo.gerproject.model.PlaceService;
import com.demo.gerproject.service.PlaceServiceService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/services")
@AllArgsConstructor
public class PlaceServiceController {
	private final PlaceServiceService placeService;
	
	@GetMapping
	public ResponseEntity<List<PlaceService>> getPlaceServices() {
		return new ResponseEntity<>(placeService.getPlaceServices(), HttpStatus.OK);
	}
}
