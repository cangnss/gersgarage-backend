package com.demo.gerproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.gerproject.model.PlaceService;

@Repository
public interface PlaceServiceRepository extends JpaRepository<PlaceService, Integer>{

}
