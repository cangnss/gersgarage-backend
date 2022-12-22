package com.demo.gerproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.gerproject.model.Stock;
import com.demo.gerproject.repository.StockRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StockService {
	private final StockRepository stockRepository;
	
	public List<Stock> getStocks(){
		return stockRepository.findAll();
	}
}
