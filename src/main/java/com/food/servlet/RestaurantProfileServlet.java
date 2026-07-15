package com.food.servlet;

import java.io.IOException;

import com.tap.UserDAO.ResImp;
import com.tap.model.RestaurantAdmin;
import com.tap.model.Restaurent;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/restaurantProfile")
public class RestaurantProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("admin") == null) {
			resp.sendRedirect("login.jsp");
			return;
		}

		RestaurantAdmin admin = (RestaurantAdmin) session.getAttribute("admin");

		int restaurantId = admin.getRestaurant_id();

		ResImp dao = new ResImp();

		Restaurent restaurant = dao.getRes(restaurantId);

		req.setAttribute("restaurant", restaurant);

		req.getRequestDispatcher("restaurantProfile.jsp").forward(req, resp);
	}
}
