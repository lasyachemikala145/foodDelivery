package com.tap.demo;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.tap.UserDAO.UserDAOImpl;
import com.tap.model.User;
import com.tap.utility.DBConnection;

public class Launch {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the name:");
		String Name=sc.nextLine();
		System.out.println("enter password:");
		String password=sc.nextLine();
		System.out.println("enter email:");
		String email=sc.nextLine();
		System.out.println("enter address:");
		String Adress=sc.nextLine();
		System.out.println("enter roll:");
		String role=sc.nextLine();
		User u = new User(Name,password,email,Adress,role);
		System.out.println(u);
		Connection con=DBConnection.getConnection();
		UserDAOImpl uD=new UserDAOImpl();
		uD.addUser(u);
		
		System.out.println("start");
		//UserDAOImpl uD=new UserDAOImpl();
		System.out.println("get the user");
		User u1=uD.getUser(1);
		System.out.println(u1);
		System.out.println("end");
			//UserDAOImpl uD=new UserDAOImpl();
		User u3=uD.getUser(1);
		u3.setAddress("godavari");
		uD.updateUser(u);
		System.out.println("user updated");
		int n=sc.nextInt();
		uD.deleteUser(n);
		List<User> alluser=uD.getAllUsers();
		for(User user:alluser) {
			System.out.println(user);
		}
	}

}
/*
 * sai
sai1
sai@gmail.com
hyderbad
hr
*/
