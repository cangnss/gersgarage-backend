package com.demo.gerproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.gerproject.model.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer>{

}
