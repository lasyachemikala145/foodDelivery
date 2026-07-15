package com.food.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.UserDAO.OrderItemImpl;
import com.tap.UserDAO.Ordersimpl;
import com.tap.model.Orders;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/myorderServlet")
public class MyordersServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	OrderItemImpl orderitemimpl=new OrderItemImpl();
	Ordersimpl orderimp=new Ordersimpl();
	HttpSession session=req.getSession();
	User user = (User) session.getAttribute("user");
	 if(user==null){

         resp.sendRedirect("login.jsp");
         return;
     }

     //Ordersimpl orderDao = new Ordersimpl();

     List<Orders> orders =
             orderimp.getOrdersByUser(user.getUser());

     req.setAttribute("orders", orders);

     req.getRequestDispatcher("myorders.jsp")
             .forward(req, resp);
 }
}

