package com.food.servlet;

import java.io.IOException;

import com.tap.UserDAO.MenuDAOimp;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateMenu")
public class UpdateMenuServlet extends HttpServlet {


	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        int menu_id = Integer.parseInt(req.getParameter("menu_id"));

	        int res_id = Integer.parseInt(req.getParameter("res_id"));

	        String nameofitem = req.getParameter("nameofitem");

	        float price = Float.parseFloat(req.getParameter("price"));

	        float rating = Float.parseFloat(req.getParameter("rating"));

	        String category = req.getParameter("category");

	        String imgurl = req.getParameter("imgurl");

	        Menu menu = new Menu(
	                menu_id,
	                nameofitem,
	                price,
	                rating,
	                category,
	                res_id,
	                imgurl
	        );

	        MenuDAOimp dao = new MenuDAOimp();

	        dao.updateMenu(menu);

	        resp.sendRedirect("manageMenu");
	    }
	}

