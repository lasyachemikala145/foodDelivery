package com.food.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.tap.UserDAO.ResImp;
import com.tap.model.Restaurent;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/callRestaurantServlet")
public class RestaurantServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter()
;		//try {
		ResImp resimp=new ResImp();
		List<Restaurent>allrestaurants=resimp.getAllRestaurent();
		System.out.println("Restaurant List Size = " + allrestaurants.size());
		req.setAttribute("allrestaurants",allrestaurants);
//		
		RequestDispatcher rd =
				req.getRequestDispatcher("restaurant.jsp");
				rd.forward(req, resp);

}
}
