package com.tap.DAO;

import java.util.List;

import com.tap.model.Restaurent;

//import com.res.model.Restaurent;


public interface ResInterface {

	
		// TODO Auto-generated method stub
		void addRes(Restaurent res);
		Restaurent getRes(int res_id);//If you want to get any restaurant row
		void updateRes(Restaurent res);//Update  it restaurant will be updated in the rest itself it is not return anything
		void deleteRes(int res_id);
		List<Restaurent> getAllRestaurent();
		List<Restaurent> filterRestaurants(
				String category,
				String cuisine,
				String rating,
				String price,
				String sort);
		
		

}
