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

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	@Id
	@SequenceGenerator(
			name="comment_sequence",
			sequenceName="comment_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.IDENTITY,
			generator = "comment_sequence"
	)
	private int id;
	private String text;
	private int customerId;
	private int placeId;
}
