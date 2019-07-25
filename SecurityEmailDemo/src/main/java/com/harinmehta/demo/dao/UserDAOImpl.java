package com.harinmehta.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harinmehta.demo.user.AppUser;

@Repository
public class UserDAOImpl implements UserDAO {

	private EntityManager entityManager;
	
	@Autowired
	public UserDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public void changePassword(AppUser theUser, String newPassword) {
		
		
		
	}

	@Override
	public String getpreviousPassword(String username) {
		
		Query theQuery = entityManager.createQuery("select password from AppUser where username=:username ");
		theQuery.setParameter("username", username);
		
		List<String> prevPassword = theQuery.getResultList();
		
		return prevPassword.get(0).substring(8);
	}

}
