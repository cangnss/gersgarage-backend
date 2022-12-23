package com.demo.gerproject.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
	
	@Id
	private int id;
	private Date bkDate;
	private String description;
	private int available;
	private int customerId;
	private int placeId;
	private int place_service_type=1;
	private int vehicle_status=0;
	
}
