package com.demo.gerproject.model;

import java.util.Date;

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
public class Schedule {
	
	@Id
	@SequenceGenerator(
			name="schedule_sequence",
			sequenceName="schedule_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "schedule_sequence"
	)
	private int id;
	private Date bkDate;
	private String description;
	private int available;
	private int customerId;
	private int placeId;
	private int place_service_type=1;
	private int vehicle_status=0;
	
}
