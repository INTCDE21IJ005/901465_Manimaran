package com.cts.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.restapi.model.Employee;
import com.cts.restapi.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return empService.getEmployeeById(id);
	}
	@GetMapping
	public List<Employee> getEmployees(){
		return empService.getEmployees();
	}
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable int id,@RequestBody Employee emp) {
		return empService.updateEmployee(id, emp);
	}
	@PostMapping
	public Employee addEmployee(@RequestBody Employee emp) {
		return empService.addEmployee(emp);
	}
	@DeleteMapping("/{id}")
	public Employee deleteEmployee(@PathVariable int id) {
		return empService.deleteEmployee(id);
	}
	
	
	
}
