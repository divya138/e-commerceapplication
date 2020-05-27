package com.ecommerceapplication.dto;

import javax.validation.constraints.NotEmpty;

public class UserDto {
	@NotEmpty(message = "email Should not be blank")
	private String email;
	@NotEmpty(message = "Password Should not be blank")
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
