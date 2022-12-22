package com.demo.gerproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
}
