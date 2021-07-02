package com.javainuse.springbootsecurity.dao.enitity;

public class AuthenticationRequest {
	
	private String emailId;
	private String password;
	
	
	public AuthenticationRequest(String email, String password) {
		super();
		this.emailId = email;
		this.password = password;
	}
	
	public AuthenticationRequest()
	{
		
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
