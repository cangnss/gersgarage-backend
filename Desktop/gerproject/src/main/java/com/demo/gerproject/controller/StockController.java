package com.demo.gerproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.gerproject.model.Stock;
import com.demo.gerproject.service.StockService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/stocks")
@AllArgsConstructor
public class StockController {
	private final StockService stockService;
	
	@GetMapping
	public ResponseEntity<List<Stock>> getStocks(){
		return new ResponseEntity<>(stockService.getStocks(), HttpStatus.OK);
	}
}
