package com.example.demo.service;

import java.util.List;

import com.example.demo.module.Employee;

public interface EmployeeService {

	Employee addEmplooyee(Employee e);
	
	Employee empById(Integer eid);
	
//	List<Employee> empByDesignation(String designation);
	List<Employee> emplessSal(Double sal);
	
	Employee updateEmployee(Employee e);
	
	Employee deleteEmployee(Integer eid);
}
