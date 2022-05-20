package com.skc.transaction.model;

public class FormModel {

	String userName;
	String password;
	
	public FormModel() {
		
	}		
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "FormModel [userName=" + userName + ", password=" + password + "]";
	}
}
