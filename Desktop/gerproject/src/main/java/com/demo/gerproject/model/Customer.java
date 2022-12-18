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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	
	@Id
	private int id;
	
	private String firstname;
	
	private String lastname;
	
	private int role = 0;
	
	private int placeId;
	
	private Date createdAt = new Date();

}
