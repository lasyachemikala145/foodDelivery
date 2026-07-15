package com.food.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.UserDAO.ResImp;
import com.tap.model.Restaurent;
import com.tap.UserDAO.MenuDAOimp;
import com.tap.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String keyword=req.getParameter("Keyword");
		System.out.println(keyword);
////		ResImp resimp=new ResImp();
////		List<Restaurent> restaurentlist=resimp.searchRestaurant(keyword);
//		MenuDAOimp menuDAO = new MenuDAOimp();
//		List<Menu> menuList = menuDAO.searchMenu(keyword);
//		//req.setAttribute("restaurentlist", restaurentlist);
		ResImp resimp = new ResImp();
		List<Restaurent> restaurentlist = resimp.searchRestaurant(keyword);

		if (!restaurentlist.isEmpty()) {

		    req.setAttribute("type", "restaurant");
		    req.setAttribute("restaurentlist", restaurentlist);

		} else {

		    MenuDAOimp menuDAO = new MenuDAOimp();
		    List<Menu> menuList = menuDAO.searchMenu(keyword);

		    req.setAttribute("type", "menu");
		    req.setAttribute("menuList", menuList);
		}
		
		RequestDispatcher rd=req.getRequestDispatcher("searchresult.jsp");
		rd.forward(req, resp);
		
		
	}

}
