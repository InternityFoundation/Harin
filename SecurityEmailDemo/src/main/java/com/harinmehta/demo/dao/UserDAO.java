package com.harinmehta.demo.dao;

import com.harinmehta.demo.user.AppUser;

public interface UserDAO {

	void changePassword(AppUser theUser, String newPassword);

	String getpreviousPassword(String username);

}
