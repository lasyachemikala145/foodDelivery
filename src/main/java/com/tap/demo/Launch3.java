package com.tap.demo;

import java.util.Scanner;
import java.util.List;
import com.tap.UserDAO.MenuDAOimp;
import com.tap.model.Menu;

public class Launch3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		MenuDAOimp menuimp=new MenuDAOimp();
		while (true) {

			System.out.println("=====MENU =====");
			System.out.println("1. Add");
			System.out.println("2. Get");
			System.out.println("3. Update One Field");
			System.out.println("4. Delete");
			System.out.println("5.get all menu object");


			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
		switch(choice) {
		case 1:
			//for add menu
			
			System.out.println("enter the name:");
			String name=sc.nextLine();
			System.out.println("price of the item:");
			float price=sc.nextInt();
			System.out.println("rating of the item:");
			float item=sc.nextFloat();
			sc.nextLine();
			System.out.println("Category:");
			String category=sc.nextLine();
			System.out.println("Restaurent id");
			int res_id=sc.nextInt();
			System.out.println("UserID:");
			int user_id=sc.nextInt();
			Menu m=new Menu(name,price,item,category,res_id);
			menuimp.addMenu(m);

			break;
			//for get menu row
		case 2:
			int menu_id=sc.nextInt();
			Menu m1=menuimp.getMenu(menu_id);
			System.out.println(m1);//java internally cl toString();
			break;

			//for update
		case 3:
			System.out.println("enter menu id:");
			int menuid=sc.nextInt();//we should scan res_id becz we need to mention which id need to chnage
			sc.nextLine();
			System.out.println("enter the name:");
			String name1=sc.nextLine();
			System.out.println("price of the item:");
			float price1=sc.nextFloat();
			System.out.println("rating of the item:");
			float item1=sc.nextFloat();
			sc.nextLine();
			System.out.println("Category:");
			String category1=sc.nextLine();
			System.out.println("Restaurent id");
			int res_id1=sc.nextInt();
			sc.nextLine();
			String imgurl=sc.nextLine();
			Menu m3=new Menu(menuid,name1,price1,item1,category1,res_id1,imgurl);
			menuimp.updateMenu(m3);
			break;

			//for delete the row 
		case 4:
			int menu_id1=sc.nextInt();
			menuimp.delteMenu(menu_id1);
			break;

			//for getting all rows
		case 5:
			List<Menu> limenu=menuimp.getAllMenu();
			for(Menu menuli:limenu) {
				System.out.println(menuli);
			}
			break;
		default:
			System.out.println("Invalid Choice");
		}
		}
	}
}
