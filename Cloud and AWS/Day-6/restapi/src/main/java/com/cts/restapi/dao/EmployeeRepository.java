package com.cts.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.restapi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
