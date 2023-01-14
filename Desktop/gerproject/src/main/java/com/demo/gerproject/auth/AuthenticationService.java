package com.demo.gerproject.auth;

import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.gerproject.config.JwtService;
import com.demo.gerproject.model.Customer;
import com.demo.gerproject.model.Role;
import com.demo.gerproject.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final CustomerRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  // this method create customer object then create token for every customer.
  public AuthenticationResponse register(RegisterRequest request) {
	  
    var user = Customer.builder()
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .username(request.getUsername())
        .placeId(1)
        .createdAt(new Date())
        .role(Role.USER)
        .build();
    repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

  // check customer email or password then login system
  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var user = repository.findByEmail(request.getEmail())
        .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
    	.id(user.getId())
    	.firstname(user.getFirstname())
    	.lastname(user.getLastname())
    	.username(user.getUsername())
    	.role(user.getRole())
        .token(jwtToken)
        .build();
  }
  
  public boolean findEmail(String email) {
	  Optional<Customer> c = repository.findByEmail(email);
	  System.out.println(c);
	  if(c.isEmpty()) {
		  return true;
	  }else {
		  return false;
	  }
  }
}
