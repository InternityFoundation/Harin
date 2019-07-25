package com.harinmehta.demo.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewPassUser {
	
	@NotNull(message = "is required")
	@Size(min=1, message= "is required")
	private String username;
	
	@NotNull(message = "is required")
	@Size(min=1, message="is required")
	private String previousPassword;

	@NotNull(message = "is required")
	@Size(min=1, message="is required")
	private String newPassword;

	@NotNull(message = "is required")
	@Size(min=1, message="is required")
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPreviousPassword() {
		return previousPassword;
	}

	public void setPreviousPassword(String previousPassword) {
		this.previousPassword = previousPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public NewPassUser() {}
	
}
