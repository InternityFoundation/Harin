package com.harinmehta.jdbc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.harinmehta.jdbc.entity.Employee;

public class EmployeeDAO {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Employee.class).buildSessionFactory();	
	
	public void add(Employee employee) {


		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();

			System.out.println("Done! Id:" + employee.getId());
		} finally {
			factory.close();
		}
		
	}

	public void getEmployee(int id) {
		
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Employee emp = session.get(Employee.class, id);
			
			if(emp == null) {
				
				// if id <100 : start with 0 , else start with id-100
				int start = id<100 ? 0 : id-100;
						
				Query query = session.createQuery("FROM Employee"); 
				query.setFirstResult(start);
				query.setMaxResults(id);
				
				List<Employee> theEmployees = query.getResultList();
				for(Employee tempEmployee : theEmployees) {
					System.out.println(tempEmployee);
				}
			}
			else {
				System.out.println(emp);
			}
			
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
			
	}

}
