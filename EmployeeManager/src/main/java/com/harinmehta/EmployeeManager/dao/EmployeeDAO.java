package com.harinmehta.EmployeeManager.dao;

import java.util.List;

import com.harinmehta.EmployeeManager.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public void save(Employee employee);
	
	public Employee findById(int theId);

	public List<Employee> findLastHundred(int employeeId);
	
}
