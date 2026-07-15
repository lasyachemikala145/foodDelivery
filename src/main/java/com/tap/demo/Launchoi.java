package com.tap.demo;

import java.util.List;
import java.util.Scanner;

import com.tap.UserDAO.MenuDAOimp;
import com.tap.UserDAO.OrderItemImpl;
import com.tap.model.OrderItem;

public class Launchoi {
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	OrderItemImpl oimp=new OrderItemImpl();
	while (true) {

		System.out.println("order item:");
		System.out.println("1. Add");
		System.out.println("2. Get");
		System.out.println("3. Update one row");
		System.out.println("4. Delete");
		System.out.println("5.get all rows");


		System.out.print("Enter your choice: ");
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1://for adding data 
			int order_id=sc.nextInt();
			//int menu_id=sc.nextInt();
			int quantity=sc.nextInt();
			String itemName=sc.nextLine();
			double price=sc.nextDouble();
			OrderItem oi=new OrderItem(order_id, quantity,itemName,price);
			oimp.addOrderItem(oi);
			break;

		case 2://to get data 
			int orderItem_id=sc.nextInt();
			OrderItem oig=oimp.getOrderItem(orderItem_id);
			System.out.println(oig);
			break;

		case 3://update the data 
			int order_idu=sc.nextInt();
			//int menu_idu=sc.nextInt();
			int quantityu=sc.nextInt();
			String itemName1=sc.nextLine();
			double price1=sc.nextDouble();
			OrderItem oiu=new OrderItem(order_idu, quantityu,itemName1,price1);
			oimp.updateOrderItem(oiu);
			break;
		case 4://to delete a row
			int orderItem_idd=sc.nextInt();
			oimp.deleteOrderItem(orderItem_idd);
			break;

		case 5://to get all rows 
			List<OrderItem> li=oimp.getAllOrderItem();		
			for(OrderItem oili:li) {
				System.out.println(li);
			}
			break;

		default:
			System.out.println("Invalid");
		}
	}
}
}



