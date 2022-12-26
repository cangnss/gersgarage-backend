package com.demo.gerproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.gerproject.model.Customer;
import com.demo.gerproject.model.Employee;
import com.demo.gerproject.repository.CustomerRepository;
import com.demo.gerproject.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
	private final EmployeeRepository employeeRepository;

	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee is not found!"));
	}
	
	public void updateEmployee(int id, Employee newEmployee) {
        Employee oldEmployee = getEmployeeById(id);
        oldEmployee.setFirstname(newEmployee.getFirstname());
        oldEmployee.setLastname(newEmployee.getLastname());
        oldEmployee.setSalary(newEmployee.getSalary());
        employeeRepository.save(oldEmployee);
    }

}
