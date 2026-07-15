package com.tap.model;

import java.sql.Timestamp;

public class User {


	// TODO Auto-generated method stub00
	int user_id;
	String Name;
	String password;
	String email;
	String Adress;
	String role;
	Timestamp createDate;
	Timestamp lastloginDate;
	String phone;


	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public User(int user_id, String name, String password, String email, String adress, String role,
			Timestamp createDate, Timestamp lastloginDate, String phone) {
		super();
		this.user_id = user_id;
		Name = name;
		this.password = password;
		this.email = email;
		Adress = adress;
		this.role = role;
		this.createDate = createDate;
		this.lastloginDate = lastloginDate;
		this.phone = phone;
	}
	public User(String Name, String password, String email, String Adress, String role) {
		super();
		this.Name = Name;
		this.password = password;
		this.email = email;
		this.Adress = Adress;
		this.role = role;
		//this.createDate = createDate;
		//this.lastloginDate = lastloginDate;
	}
	public User() {
		
	}
	public User(int user_id, String name, String password, String email, String adress, String role,
			Timestamp createDate, Timestamp lastloginDate) {
		super();
		System.out.println("store inside instance");
		this.user_id = user_id;
		Name = name;
		this.password = password;
		this.email = email;
		Adress = adress;
		this.role = role;
		this.createDate = createDate;
		this.lastloginDate = lastloginDate;
	}


	public int getUser() {
		return user_id;
	}

	public void setUser(int user_id) {
		this.user_id = user_id;
	}

	public  String getUserName() {
		return Name;
	}

	public void setUserName(String Name) {
		this.Name = Name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return Adress;
	}

	public void setAddress(String Adress) {
		this.Adress = Adress;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getLastloginDate() {
		return lastloginDate;
	}

	public void setLastloginDate(Timestamp lastloginDate) {
		this.lastloginDate = lastloginDate;
	}
	

	@Override
	public String toString() {
		return "User [user=" + user_id + ", userName=" + Name + ", password=" + password + ", email=" + email
				+ ", address=" + Adress + ", role=" + role + ", createDate=" + createDate + ", lastloginDate="
				+ lastloginDate + "]";
	}

	public static void main(String[] args) {
		//User user=new User();
	}




}

