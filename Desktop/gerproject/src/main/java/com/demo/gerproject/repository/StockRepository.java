package com.demo.gerproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.gerproject.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

}
