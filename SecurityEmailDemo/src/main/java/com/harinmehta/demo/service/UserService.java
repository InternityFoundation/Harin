package com.harinmehta.demo.service;

import javax.validation.Valid;

import com.harinmehta.demo.user.NewPassUser;

public interface UserService {
	
	public String getpreviousPassword(String username);

	public void sendEmail(NewPassUser newPassUser);

	
}
