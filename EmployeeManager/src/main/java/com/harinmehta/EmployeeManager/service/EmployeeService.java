package com.harinmehta.EmployeeManager.service;

import java.util.List;

import com.harinmehta.EmployeeManager.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public void save(Employee theEmployee);
	
	public Employee findById(int theId);

	public List<Employee> findLastHundred(int employeeId);
	
}
