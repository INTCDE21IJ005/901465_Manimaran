package com.cts.restapi.service;

import java.util.List;

import com.cts.restapi.model.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();
	public Employee addEmployee(Employee employee);
	public Employee deleteEmployee(int id);
	public Employee updateEmployee(int id,Employee employee);
	public Employee getEmployeeById(int id);
}
