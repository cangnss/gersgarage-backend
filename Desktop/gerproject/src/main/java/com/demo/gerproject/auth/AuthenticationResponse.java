package com.demo.gerproject.auth;

import com.demo.gerproject.model.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
	
  private int id;
  private String firstname;
  private String lastname;
  private String username;
  private String token;
  private Role role;
}
