package com.tap.demo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;


import com.tap.UserDAO.Ordersimpl;
import com.tap.model.Orders;

public class Launch4 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	 Ordersimpl oimp=new Ordersimpl();
	

	while(true) {

	    System.out.println("ORDERS :");

	    System.out.println("1. Add");
	    System.out.println("2. Get");
	    System.out.println("3. Update");
	    System.out.println("4. Delete");
	    System.out.println("5. Get All");

	    int choice = sc.nextInt();

	    switch(choice) {

	    case 1:

	        System.out.println("Enter User Id:");
	        int userId = sc.nextInt();

	        System.out.println("Enter Restaurant Id:");
	        int resId = sc.nextInt();

	        System.out.println("Enter Final Price:");
	        float price = sc.nextFloat();

	        sc.nextLine();

	        System.out.println("Enter Order Date and Time (yyyy-MM-ddTHH:mm:ss):");

//	        LocalDateTime orderDate =
//	                LocalDateTime.parse(sc.nextLine());
	        LocalDateTime orderDate =
	                LocalDateTime.now();

	        System.out.println("Enter Payment Status:");
	        String status = sc.nextLine();

	        Orders o = new Orders(userId,resId,price,orderDate,status);

	        oimp.addOrder(o);

	        break;

	    case 2:

	        System.out.println("Enter Order Id:");

	        int id = sc.nextInt();

	        Orders ord=oimp.getOrder(id);
	        System.out.println(ord);

	        break;

	    case 3:

	        System.out.println("Enter Order Id:");
	        int oid = sc.nextInt();

	        System.out.println("Enter User Id:");
	        int uid = sc.nextInt();

	        System.out.println("Enter Restaurant Id:");
	        int rid = sc.nextInt();

	        System.out.println("Enter Final Price:");
	        float fp = sc.nextFloat();

	        sc.nextLine();

	        System.out.println("Enter Order Date (yyyy-mm-dd):");
	        LocalDateTime orderDat =
	                LocalDateTime.now();

	        System.out.println("Enter Payment Status:");
	        String st = sc.nextLine();

	        Orders obj = new Orders(oid,uid,rid,fp,orderDat,st);

	        oimp.updateOrder(obj);

	        break;

	    case 4:

	        System.out.println("Enter Order Id:");

	        int deleteId = sc.nextInt();

	        oimp.deleteOrder(deleteId);

	        break;

	    case 5:

	        List<Orders> list = oimp.getAllOrders();

	        for(Orders orde : list) {

	            System.out.println(orde);

	        }

	        break;

	    default:

	        System.out.println("Invalid Choice");
	    }

	}

}
}
