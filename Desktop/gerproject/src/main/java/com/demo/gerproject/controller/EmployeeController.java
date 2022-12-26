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

	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees() {
		return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
		return new ResponseEntity<>(getEmployeeById(id), HttpStatus.OK);
	}

	private Employee getEmployeeById(int id) {
		return employeeService.getEmployeeById(id);
	}

	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> getEmployee(@PathVariable int id, @RequestBody Employee employee) {
		Employee oldEmployee = getEmployeeById(id);
		System.out.println("data:" + employee.getId() + employee.getFirstname() + employee.getLastname() + employee.getSalary());
		oldEmployee.setFirstname(employee.getFirstname());
		oldEmployee.setLastname(employee.getLastname());
		oldEmployee.setSalary(employee.getSalary());
		employeeService.updateEmployee(id, oldEmployee);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
