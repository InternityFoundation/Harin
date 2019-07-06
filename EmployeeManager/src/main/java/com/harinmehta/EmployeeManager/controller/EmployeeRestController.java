package com.harinmehta.EmployeeManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harinmehta.EmployeeManager.entity.Employee;
import com.harinmehta.EmployeeManager.service.EmployeeService;

@RestController
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		
		return employeeService.findAll();		
	}
	
	@GetMapping("/employees/{employeeId}")
	public Object findById(@PathVariable int employeeId) {
		
		Object result = employeeService.findById(employeeId);
		
		if(result == null) {
		    // create a findLastHundred()
		    result = findLastHundred(employeeId);
		}
		
		return result;
	}
	
	// here is the method for last 100 employees
	
	public List<Employee> findLastHundred(int employeeId){
		
		return employeeService.findLastHundred(employeeId);
		
		
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
	
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
}
