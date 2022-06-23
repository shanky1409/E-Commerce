package com.practice.spring.ecom.customer.models;

public class CustomerLogin {

	private String email;
	private String password;
	
	public CustomerLogin(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public CustomerLogin() {
	}
	
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
	
	@Override
	public String toString() {
		return "CustomerLogin [email=" + email + ", password=" + password + "]";
	}
	
}
