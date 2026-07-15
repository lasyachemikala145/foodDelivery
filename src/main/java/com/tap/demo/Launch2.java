package com.tap.demo;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.tap.UserDAO.ResImp;
import com.tap.model.Restaurent;



public class Launch2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResImp resimp=new ResImp();
		Scanner sc=new Scanner(System.in);
		//for add users

		//	int res_id=sc.nextInt();
		//		sc.nextLine();
		while (true) {

			System.out.println("===== RESTAURANT MENU =====");
			System.out.println("1. Add");
			System.out.println("2. Get");
			System.out.println("3. Update One Field");
			System.out.println("4. Delete");
			System.out.println("5.get all users");
			System.out.println("6. Getone restaurent");
			


			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				System.out.println("enter the name:");
				String name=sc.nextLine();
				System.out.println("enter delivarytiming:");
				int deliveryTime=sc.nextInt();
				sc.nextLine();
				System.out.println("enter description:");
				String description=sc.nextLine();
				System.out.println("enter discount:");
				float discount=sc.nextFloat();
				System.out.println("enter rating:");
				float rating=sc.nextFloat();
				sc.nextLine();
				System.out.println("enter image_path:");
				String imageUrl=sc.nextLine();
				System.out.println("emter address:");
				String address=sc.nextLine();
				System.out.println("enter cusine type");
				String cuisine=sc.nextLine();
				LocalTime openTime = LocalTime.parse(sc.next());
				LocalTime closeTime = LocalTime.parse(sc.next());

				Restaurent res=new Restaurent(name, address, cuisine, deliveryTime, rating,discount, openTime,closeTime,imageUrl,description) ;
				resimp.addRes(res);
				System.out.println(res);
				break;
			case 2:
				// to get user
				int resid=sc.nextInt();
				Restaurent r=resimp.getRes( resid);
				System.out.println(r);

				break;

			case 3:
				// to update user
				int res_id1=sc.nextInt();
				System.out.println("enter the name:");
				String name1=sc.nextLine();
				System.out.println("enter delivarytiming:");
				int deliveryTime1=sc.nextInt();
				sc.nextLine();
				System.out.println("enter description:");
				String description1=sc.nextLine();
				System.out.println("enter discount:");
				float discount1=sc.nextFloat();
				System.out.println("enter rating:");
				float rating1=sc.nextFloat();
				sc.nextLine();
				System.out.println("enter image_path:");
				String imageUrl1=sc.nextLine();
				System.out.println("emter address:");
				String add1=sc.nextLine();
				String cuisine1=sc.nextLine();
				LocalTime openTime1 = LocalTime.parse(sc.next());
				LocalTime closeTime1= LocalTime.parse(sc.next());
				Restaurent res1=new Restaurent(res_id1, name1, add1, cuisine1, deliveryTime1, rating1,discount1, openTime1,closeTime1,imageUrl1,description1) ;
				resimp.updateRes(res1);
				break;

			case 4:
				//for deleting a row 
				System.out.println("enter id");
				int resid1=sc.nextInt();
				resimp.deleteRes(resid1);
				break;
			case 5:
				List<Restaurent> allres=resimp.getAllRestaurent();
				for(Restaurent all:allres) {
					System.out.println(allres);
				}
				break;
			case 6:
				int res_id=sc.nextInt();
				List<Restaurent> allres1=resimp.getbyRestaurent(res_id);

			default:
				System.out.println("Invalid Choice");
			}
		}
	}
}


