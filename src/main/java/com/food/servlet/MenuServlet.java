package com.food.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.UserDAO.MenuDAOimp;
import com.tap.UserDAO.ResImp;
import com.tap.model.Menu;
import com.tap.model.Restaurent;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/menu")
public class MenuServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenuDAOimp menuDao = new MenuDAOimp();
		int restaurantID=Integer.parseInt(req.getParameter("restaurantID"));
		List<Menu> allMenuByRestaurant = menuDao.getAllMenuByRestaurant(restaurantID);
		req.setAttribute("allMenuByRestaurant",allMenuByRestaurant);
		RequestDispatcher rd=req.getRequestDispatcher("menu.jsp");
		rd.forward(req, resp);
		
	}

}
