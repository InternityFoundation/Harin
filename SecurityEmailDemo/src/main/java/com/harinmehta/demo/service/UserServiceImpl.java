package com.harinmehta.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.harinmehta.demo.dao.UserDAO;
import com.harinmehta.demo.user.NewPassUser;

@Service
public class UserServiceImpl implements UserService {

	private JavaMailSender mailSender;
	
	@Autowired
	public UserServiceImpl(JavaMailSender javaMailSender) {
		this.mailSender = javaMailSender;
	}
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public String getpreviousPassword(String username) {
		
		return userDAO.getpreviousPassword(username);
	}
	
	@Override
	public void sendEmail(NewPassUser newPassUser) throws MailException{
		
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setText(" Hi,Your password has been changed to "+ newPassUser.getNewPassword());
		mail.setTo(newPassUser.getEmail());		
		mail.setFrom("harinmehta17@gmail.com");
		mail.setSubject("Password Changed!");	
		System.out.println("Email:"+ newPassUser.getEmail()+" Passsword:"+newPassUser.getNewPassword());
		mailSender.send(mail);
		
	}

}
