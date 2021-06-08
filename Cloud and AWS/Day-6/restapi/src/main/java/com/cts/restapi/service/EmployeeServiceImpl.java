package com.cts.restapi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.restapi.dao.EmployeeRepository;
import com.cts.restapi.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository empRepo;
	
	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empRepo.save(employee);
	}

	@Override
	public Employee deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Employee emp = empRepo.findById(id).get();
		empRepo.deleteById(id);
		return emp;
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee> opt = empRepo.findById(id);
		if(!opt.isPresent()) {
			throw new RuntimeException("Employee with "+id+" not found!!!!");
		}
		Employee emp = opt.get();
		if(employee.getName()!=null) {
			emp.setName(employee.getName());
		}
		if(employee.getAge()!=0) {
			emp.setAge(employee.getAge());
		}
		if(employee.getGender()!=null) {
			emp.setGender(employee.getGender());
		}
		if(employee.getSalary()!=0) {
			emp.setSalary(employee.getSalary());
		}
		empRepo.save(emp);
		return employee;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		
		return empRepo.findById(id)
				.orElseThrow();
	}

}
