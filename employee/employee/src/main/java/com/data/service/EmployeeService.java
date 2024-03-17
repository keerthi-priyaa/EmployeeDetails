package com.data.service;

import com.data.entity.Employee;

import java.util.List;

public interface EmployeeService {

	public List<Employee> findAllEmployee();
	public Employee saveEmployee(Employee theEmployee);
	public void deleteById(Integer theId);
	
}