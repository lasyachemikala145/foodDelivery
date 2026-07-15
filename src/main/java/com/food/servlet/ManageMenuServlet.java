
	package com.food.servlet;

	import java.io.IOException;
	import java.util.List;

	import com.tap.UserDAO.MenuDAOimp;
	import com.tap.model.Menu;
import com.tap.model.RestaurantAdmin;

import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

	@WebServlet("/manageMenu")
	public class ManageMenuServlet extends HttpServlet {

	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	    	HttpSession session = req.getSession(false);
	    	//HttpSession session = req.getSession(false);

	    	if (session == null || session.getAttribute("admin") == null) {
	    	    resp.sendRedirect("login.jsp");
	    	    return;
	    	}

	    	//RestaurantAdmin admin = (RestaurantAdmin) session.getAttribute("admin");

	        RestaurantAdmin admin = (RestaurantAdmin) session.getAttribute("admin");


	    	int res_id = admin.getRestaurant_id();

	        MenuDAOimp dao = new MenuDAOimp();

	        List<Menu> menuList = dao.getAllMenuByRestaurant(res_id);

	        req.setAttribute("menuList", menuList);

	        req.getRequestDispatcher("manageMenu.jsp").forward(req, resp);
	    }  

	        
	}

