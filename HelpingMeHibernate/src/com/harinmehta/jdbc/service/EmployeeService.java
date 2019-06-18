package com.harinmehta.jdbc.service;

import com.harinmehta.jdbc.dao.EmployeeDAO;
import com.harinmehta.jdbc.entity.Employee;

public class EmployeeService {

	
	public void addEmployee(Employee employee) {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.add(employee);
		
	}

	public void getEmployee(int id) {
		new EmployeeDAO().getEmployee(id); // creating EmployeeDAO object and calling getEmployee
	}

}
