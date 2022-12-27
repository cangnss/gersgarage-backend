package com.demo.gerproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vehicle {

	@Id
	@SequenceGenerator(
			name="vehicle_sequence",
			sequenceName="vehicle_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "vehicle_sequence"
	)
	private int id;
	private String vehicleType;
	private String vehicleEngineType;
	private String brand;
	private double km;
	private int v_year;
	private String model;
	private int customerId;
}
