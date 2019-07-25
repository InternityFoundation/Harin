package com.harinmehta.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harinmehta.demo.service.UserService;
import com.harinmehta.demo.user.AppUser;
import com.harinmehta.demo.user.NewPassUser;

@RestController
public class AppController {
	
	@Autowired
	private UserDetailsManager userDetailsManager;
	
	@Autowired
	private UserService userService;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	

	@RequestMapping("/")
	public String home() {
		
		return "For Registration : POST - /api/register || For Login : GET - /api/login "
				+ "|| For Password Change : PUT - /api/changePassword || For Logout : /logout";
	}
	
	@RequestMapping("/api/login")
	public String login() {
		
		return"You are logged in";
	}
	
	@PostMapping("/api/register")
	public String register(@Valid @RequestBody AppUser theUser,
							BindingResult theBindingResult) {
		
		String userName = theUser.getUsername();

		if(theBindingResult.hasErrors()) {
			return "Username/password cannot be empty";
		}
		
		boolean userExists = userDetailsManager.userExists(userName);
		
		if(userExists) {
			return "Username already exists";
		}
		
		String encodedPassword = passwordEncoder.encode(theUser.getPassword());
		
		encodedPassword = "{bcrypt}" + encodedPassword;
		
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");
		
		User tempUser = new User(userName, encodedPassword, authorities);
		
		userDetailsManager.createUser(tempUser);
		return"Thanks for registration";
	}
	
	@PutMapping("/api/changePassword")
	public String changePassword(@Valid @RequestBody NewPassUser newPassUser,
								BindingResult theBindingResult) {
		
		// send username + previous password + new password + email 
		String username = newPassUser.getUsername();
		String loggedUsername;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(principal instanceof UserDetails) {			
			loggedUsername = ((UserDetails)principal).getUsername();
		}else {
			loggedUsername = principal.toString();
		}
		if(!username.equals(loggedUsername)) {
			return "Enter credentials for logged in user";
		}
		
		if(theBindingResult.hasErrors()) {
			return "Any parameter can't be null";
		}
		
		// code to check if user is verified
		// previousPassword must match the password in database
		// get password from database through service, dao layers
		
		String prevPassword =  userService.getpreviousPassword(username);
		
		if(passwordEncoder.matches(newPassUser.getPreviousPassword(), prevPassword)) {
			// update database
			this.userDetailsManager.changePassword(passwordEncoder.encode(prevPassword), 
													"{bcrypt}"+passwordEncoder.encode(newPassUser.getNewPassword()));			
			// send email			
			try {
				userService.sendEmail(newPassUser);
			}catch(MailException e) {
				e.printStackTrace();
			}		
			return"Password reset successfull!";
		}
		return "Wrong password";
	}
	
}
