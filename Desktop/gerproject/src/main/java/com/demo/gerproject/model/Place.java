package com.demo.gerproject.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Place {
	
	@Id
	private int id;
	private String name;

}
