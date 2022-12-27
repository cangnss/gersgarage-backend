package com.demo.gerproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.gerproject.model.Customer;
import com.demo.gerproject.model.Place;
import com.demo.gerproject.model.PlaceService;
import com.demo.gerproject.repository.PlaceServiceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlaceServiceService {
	private final PlaceServiceRepository placeServiceRepository;

	public List<PlaceService> getPlaceServices() {
		return placeServiceRepository.findAll();
	}
	
	public PlaceService createPlaceService(PlaceService place) {
		return placeServiceRepository.save(place);
	}

	public void deletePlaceService(int id) {
		placeServiceRepository.deleteById(id);
	}

	public PlaceService getPlaceServiceById(int id) {
		return placeServiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Place is not found!"));
	}
	
	public void updatePlaceService(int id, PlaceService newPlaceService) {
		PlaceService oldPlaceService = getPlaceServiceById(id);
		oldPlaceService.setType(newPlaceService.getType());
		oldPlaceService.setPrice(newPlaceService.getPrice());
        placeServiceRepository.save(oldPlaceService);
    }
}
