package com.food.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.UserDAO.ResImp;
import com.tap.model.Restaurent;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/FilterServlet")
public class FilterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp)
					throws ServletException, IOException {

		String category = req.getParameter("category");
		String cuisine = req.getParameter("cuisine");
		String rating = req.getParameter("rating");
		String price = req.getParameter("price");
		String sort = req.getParameter("sort");

		ResImp dao = new ResImp();

		List<Restaurent> list =
				dao.filterRestaurants(category,cuisine,rating,price,sort);

		req.setAttribute("allrestaurants", list);

		req.getRequestDispatcher("restaurant.jsp")
		.forward(req,resp);
	}
}
