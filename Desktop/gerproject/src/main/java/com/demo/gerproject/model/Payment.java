package com.demo.gerproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	
	@Id
	private int id;
	private double amount;
	private boolean type;
	private int customerId;
	private int placeId;
	
}
