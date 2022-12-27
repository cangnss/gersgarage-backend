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
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
	
	@Id
	@SequenceGenerator(
			name="stock_sequence",
			sequenceName="stock_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "stock_sequence"
	)
	private int id;
	private String item;
	private int quantity;
	private int placeId;
	private double pcs_price;
}
