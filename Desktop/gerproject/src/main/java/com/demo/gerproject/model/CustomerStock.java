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
public class CustomerStock {

	@Id
	private int id;
	private int customerId;
	private int stockId;
	private int quantity;
}
