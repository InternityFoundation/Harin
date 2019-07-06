package com.harinmehta.EmployeeManager.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harinmehta.EmployeeManager.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
		
	@Override
	public List<Employee> findAll() {
		
		Query theQuery = entityManager.createQuery("from Employee");
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public void save(Employee employee) {

		Employee dbEmployee = entityManager.merge(employee);
		
		employee.setId(dbEmployee.getId());

	}

	@Override
	public Employee findById(int theId) {
		
		Employee dbEmployee = entityManager.find(Employee.class, theId); 
		
		return dbEmployee;
	}

	@Override
	public List<Employee> findLastHundred(int employeeId) {
		
		int start = employeeId<100 ? 0 : employeeId-100;
		
		Query query = entityManager.createQuery("FROM Employee"); 
		query.setFirstResult(start);
		query.setMaxResults(employeeId);
		
		List<Employee> theEmployees = query.getResultList();
		
		return theEmployees;
	}

}
