package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;
@RestController
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	EmployeeService employeeService;
	@RequestMapping("/employee1")
	public Employee getCountryIndia() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		LOGGER.info("END");
		return context.getBean("employee1",Employee.class);
	}
	@GetMapping("/employees")
	public ArrayList<Employee> getAllEmployees(){
		LOGGER.info("START");
		LOGGER.info("END");
		return employeeService.getAllEmployees();
	}
	
}
