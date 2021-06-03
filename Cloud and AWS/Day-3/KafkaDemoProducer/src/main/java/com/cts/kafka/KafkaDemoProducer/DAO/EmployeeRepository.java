package com.cts.kafka.KafkaDemoProducer.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.kafka.KafkaDemoProducer.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
