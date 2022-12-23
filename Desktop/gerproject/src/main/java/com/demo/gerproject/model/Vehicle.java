package com.demo.gerproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vehicle {

	@Id
	private int id;
	private String vehicleType;
	private String vehicleEngineType;
	private String brand;
	private double km;
	private int v_year;
	private String model;
	private int customerId;
}
