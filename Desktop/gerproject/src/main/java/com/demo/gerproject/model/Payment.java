package com.demo.gerproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Payment {
	
	@Id
	@SequenceGenerator(
			name="payment_sequence",
			sequenceName="payment_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "payment_sequence"
	)
	private int id;
	private double amount;
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	private int customerId;
	private int placeId;
	private int scheduleId;
	
}
