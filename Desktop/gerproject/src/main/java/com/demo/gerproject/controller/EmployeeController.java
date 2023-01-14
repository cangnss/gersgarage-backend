package com.demo.gerproject.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.gerproject.model.Employee;
import com.demo.gerproject.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {
	private final EmployeeService employeeService;

	// return all employees
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees() {
		return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
	}

	// return employee by id
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
		return new ResponseEntity<>(getEmployeeById(id), HttpStatus.OK);
	}

	private Employee getEmployeeById(int id) {
		return employeeService.getEmployeeById(id);
	}

	// create employee request here then go to service
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
	}

	// update employee request here
	@PutMapping("/{id}")
	public ResponseEntity<Void> getEmployee(@PathVariable int id, @RequestBody Employee employee) {
		Employee oldEmployee = getEmployeeById(id);
		oldEmployee.setFirstname(employee.getFirstname());
		oldEmployee.setLastname(employee.getLastname());
		oldEmployee.setSalary(employee.getSalary());
		employeeService.updateEmployee(id, oldEmployee);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	// delete employee
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
