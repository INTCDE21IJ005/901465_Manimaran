package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cognizant.springlearn.dao.DepartmentDao;
import com.cognizant.springlearn.model.Department;

@Service
public class DepartmentService {
	@Autowired
	DepartmentDao departmentDao;;
	public ArrayList<Department> getAllDepartments(){
		return departmentDao.getAllDepartments();
	}
}
