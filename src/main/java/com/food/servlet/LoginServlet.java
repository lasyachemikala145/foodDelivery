package com.food.servlet;

import java.io.IOException;

import com.tap.UserDAO.RestaurantAdminDAOImpl;
import com.tap.UserDAO.UserDAOImpl;
import com.tap.model.RestaurantAdmin;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
//		String email = req.getParameter("email"); 
//		String password = req.getParameter("password"); 
//		System.out.println("Email: " + email);
//		System.out.println("Password: " + password);
//		UserDAOImpl dao = new UserDAOImpl(); 
//		User user = dao.validateUser(email, password); 
//		System.out.println(user);
//		if(user != null) {
//			HttpSession session = req.getSession();
//			session.setAttribute("user", user);
//			//session.setAttribute("loggedInUser", user);
//			resp.sendRedirect("callRestaurantServlet"); 
//			} 
//		else { 
//			req.setAttribute("errorMessage", "Invalid Email or Password");
//			req.getRequestDispatcher("login.jsp") .
//			forward(req, resp); 
//			} 
//		} 
//	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    String email = req.getParameter("email");
	    String password = req.getParameter("password");
	    String role = req.getParameter("role");

	    if("customer".equals(role)) {

	        UserDAOImpl dao = new UserDAOImpl();

	        User user = dao.validateUser(email, password);

	        if(user != null) {

	            HttpSession session = req.getSession();
	            session.setAttribute("user", user);

	            resp.sendRedirect("callRestaurantServlet");

	        } else {

	            req.setAttribute("errorMessage", "Invalid Customer Email or Password");
	            req.getRequestDispatcher("login.jsp").forward(req, resp);
	        }
	    }

	    
	    else if("Restaurant Admin".equals(role))  {

	        RestaurantAdminDAOImpl dao = new RestaurantAdminDAOImpl();

	        RestaurantAdmin admin = dao.validateAdmin(email, password);

	        if(admin != null) {

	            HttpSession session = req.getSession();
	            session.setAttribute("admin", admin);

	            resp.sendRedirect("adminDashboard");

	        } else {

	            req.setAttribute("errorMessage", "Invalid Admin Email or Password");
	            req.getRequestDispatcher("login.jsp").forward(req, resp);
	        }
	    }
	}
}

