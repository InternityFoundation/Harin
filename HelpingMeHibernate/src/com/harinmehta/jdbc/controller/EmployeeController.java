package com.harinmehta.jdbc.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.harinmehta.jdbc.entity.Employee;
import com.harinmehta.jdbc.service.EmployeeService;

public class EmployeeController {

	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	String name, address, email;
	long phoneNo;
	int exp;
	
	public void create() throws Exception  {
		// TODO Auto-generated method stub
		System.out.println("Enter Name : ");
		name = bf.readLine();
		System.out.println("Enter address : ");
		address = bf.readLine();
		System.out.println("Enter phone number : ");
		phoneNo = Long.parseLong(bf.readLine());
		System.out.println("Enter email : ");
		email = bf.readLine();
		System.out.println("Enter experience : ");
		exp = Integer.parseInt(bf.readLine());
		Employee emp = new Employee(name,address,phoneNo,email,exp);
	    EmployeeService employeeService = new EmployeeService();
	    employeeService.addEmployee(emp);
	}

	public void get() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enter Employee id : ");
		int id= Integer.parseInt(bf.readLine());
		 new EmployeeService().getEmployee(id); // creating a EmployeeService object and calling getEmployee()
	}

}
