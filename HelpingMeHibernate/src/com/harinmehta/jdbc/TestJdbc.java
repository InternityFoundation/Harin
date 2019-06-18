package com.harinmehta.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String jdbcUrl = "jdbc:mysql://localhost:3306/employee_tracker?useSSL=false";
		String user = "hbstudent";
		String pass ="hbstudent";
		
		try {
			
			System.out.println("Connecting to database : " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successful!!");
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}

}
