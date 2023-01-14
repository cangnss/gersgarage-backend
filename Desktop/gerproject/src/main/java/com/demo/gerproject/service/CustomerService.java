package com.demo.gerproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.gerproject.dao.UserVehiclesInServiceProjection;
import com.demo.gerproject.dao.VehiclesInServiceProjection;
import com.demo.gerproject.model.Customer;
import com.demo.gerproject.model.Employee;
import com.demo.gerproject.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	
	public List<Customer> getCustomers(){
		return customerRepository.findAll();
	}
	
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);
	}
	
	public Customer getCustomerById(int id) {
		return customerRepository.findById(id)
								.orElseThrow(() -> new RuntimeException("Customer is not found!"));
	}
	
	public void updateCustomer(int id, Customer newCustomer) {
		Customer oldCustomer = getCustomerById(id);
		oldCustomer.setFirstname(newCustomer.getFirstname());
		oldCustomer.setLastname(newCustomer.getLastname());
		oldCustomer.setUsername(newCustomer.getUsername());
		oldCustomer.setPassword(newCustomer.getPassword());
        customerRepository.save(oldCustomer);
    }
	
	public List<UserVehiclesInServiceProjection> getUserVehiclesInService(int id){
		return customerRepository.getUserVehiclesInService(id);
	}
}
