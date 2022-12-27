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
public class CustomerStock {

	@Id
	@SequenceGenerator(
			name="customer_stock_sequence",
			sequenceName="customer_stock_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "customer_stock_sequence"
	)
	private int id;
	private int customerId;
	private int stockId;
	private int quantity;
}
