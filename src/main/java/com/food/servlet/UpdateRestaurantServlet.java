package com.food.servlet;

import java.io.IOException;
import java.time.LocalTime;

import com.tap.UserDAO.ResImp;
import com.tap.model.Restaurent;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateRestaurant")
public class UpdateRestaurantServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		int res_id = Integer.parseInt(req.getParameter("res_id"));
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String cuisineType = req.getParameter("cuisineType");
		int deliveryTime = Integer.parseInt(req.getParameter("deliveryTime"));
		float discount = Float.parseFloat(req.getParameter("discount"));
		float rating = Float.parseFloat(req.getParameter("rating"));
		LocalTime openTime = LocalTime.parse(req.getParameter("openTime"));
		LocalTime closeTime = LocalTime.parse(req.getParameter("closeTime"));
		String imageUrl = req.getParameter("imageUrl");
		String description = req.getParameter("description");

		Restaurent restaurant = new Restaurent();

		restaurant.setRes_id(res_id);
		restaurant.setName(name);
		restaurant.setAddress(address);
		restaurant.setCuisineType(cuisineType);
		restaurant.setDeliveryTime(deliveryTime);
		restaurant.setDiscount(discount);
		restaurant.setRating(rating);
		restaurant.setOpenTime(openTime);
		restaurant.setCloseTime(closeTime);
		restaurant.setImageUrl(imageUrl);
		restaurant.setDescription(description);

		ResImp dao = new ResImp();
		dao.updateRes(restaurant);

		resp.sendRedirect("restaurantProfile.jsp");
	}
}
