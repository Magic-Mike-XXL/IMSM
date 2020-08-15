package com.ilemelamncp.IMSDMS;

public class UserModel {
	
	private String userName, email, password;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	public String getInsertionValues(UserModel model) {
		return "('"+ userName + "', '" + email + "', '" + password + "')";
	}
	
	public String getTableValues() {
		return "(User_Name, Email, Password)";
	}
}
