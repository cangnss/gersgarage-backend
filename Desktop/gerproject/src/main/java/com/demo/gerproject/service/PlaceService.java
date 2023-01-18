package com.demo.gerproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.gerproject.model.Place;
import com.demo.gerproject.repository.PlaceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlaceService {
	private final PlaceRepository placeRepository;

	public List<Place> getPlaces() {
		return placeRepository.findAll();
	}

	public Place createPlace(Place place) {
		return placeRepository.save(place);
	}

	public void deletePlace(int id) {
		placeRepository.deleteById(id);
	}

	public Place getPlaceById(int id) {
		return placeRepository.findById(id).orElseThrow(() -> new RuntimeException("Place is not found!"));
	}
}
