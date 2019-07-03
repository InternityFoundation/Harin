package com.harinmehta.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.harinmehta.jdbc.controller.EmployeeController;

public class MainClass {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
 
		EmployeeController employeeController = new EmployeeController();
		int choice, choice1;
		boolean choice0 = true;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (choice0) {
			System.out.println("Choose Operation : \n 1. Add an Employee \n 2. Get an Employee" + "\n 0. Exit");
			choice = Integer.parseInt(bf.readLine());

			switch (choice) {

			case 0:
				System.exit(0);
				break;

			case 1:
				employeeController.create();
				break;
			case 2:
				employeeController.get();
				break;
			default:
				System.out.println("Invalid input");
			}
			System.out.println("Do you still wanna operate? Press 0 to exit.");
			choice1 = Integer.parseInt(bf.readLine());
			choice0 = choice1==0 ? false : true ; 
		}
	}
}