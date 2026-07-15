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
@WebServlet("/callsignupServlet")
public class SignupServlet extends HttpServlet {

//protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	
//	
//	        // Read data from signup form
//	        String name = req.getParameter("name");
//	        String password = req.getParameter("password");
//	        String email = req.getParameter("email");
//	        String address = req.getParameter("address");
//	        String role = req.getParameter("role");
//	        String phone=req.getParameter("phone");
//	        UserDAOImpl dao = new UserDAOImpl();
//
//	        if (dao.isUserExists(email)) {
//
//	            req.setAttribute("errorMessage", "This user already exists");
//
//	            req.getRequestDispatcher("signup.jsp").forward(req, resp);
//
//	            return;
//	        }
//
//	        // Create User object
//	        User user = new User();
//
//	        user.setUserName(name);
//	        user.setPassword(password);
//	        user.setEmail(email);
//	        user.setAddress(address);
//	        user.setRole(role);
//	        user.setPhone(phone);
//
//	        
//	        // Save to database
//	        dao.addUser(user);
//	        
//	        // Redirect after successful signup
//	        resp.sendRedirect("login.jsp");
//	    }
//
//}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

    String name = req.getParameter("name");
    String password = req.getParameter("password");
    String email = req.getParameter("email");
    String address = req.getParameter("address");
    String role = req.getParameter("role");
    String phone = req.getParameter("phone");

    if (role.equals("customer")) {

        UserDAOImpl dao = new UserDAOImpl();

        if (dao.isUserExists(email)) {

            req.setAttribute("errorMessage", "This user already exists");
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
            return;
        }

        User user = new User();

        user.setUserName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setAddress(address);
        user.setRole(role);
        user.setPhone(phone);

        dao.addUser(user);

    } 
    else if (role.equals("admin")) {

        int restaurantId =
                Integer.parseInt(req.getParameter("restaurant_id"));

        RestaurantAdminDAOImpl dao = new RestaurantAdminDAOImpl();

        if (dao.isRestaurantAlreadyAssigned(restaurantId)) {

            req.setAttribute("errorMessage",
                    "This Restaurant already has an Admin");

            req.getRequestDispatcher("adminSignup.jsp")
                    .forward(req, resp);

            return;
        }

        RestaurantAdmin admin = new RestaurantAdmin();

        admin.setName(name);
        admin.setEmail(email);
        admin.setPassword(password);
        admin.setRestaurant_id(restaurantId);

        dao.addAdmin(admin);
    }

    resp.sendRedirect("login.jsp");
}
}
