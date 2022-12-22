package com.demo.gerproject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.demo.gerproject.repository.ServiceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceService {
	private final ServiceRepository serviceRepository;
	
	public List<Service> getServices(){
		return serviceRepository.findAll();
	}
}
