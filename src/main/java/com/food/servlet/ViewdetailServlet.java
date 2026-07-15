package com.food.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.UserDAO.OrderItemImpl;
import com.tap.UserDAO.Ordersimpl;
import com.tap.UserDAO.ResImp;
import com.tap.model.OrderItem;
import com.tap.model.Orders;
import com.tap.model.Restaurent;
import com.tap.model.Restaurent;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/viewdetailServlet")
public class ViewdetailServlet extends HttpServlet{
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

	 int orderId = Integer.parseInt(req.getParameter("orderId"));

	 Orders order = orderimp.getOrder(orderId);
	 ResImp resimp = new ResImp();
	 int resId =
			 order.getRes_id();
	 Restaurent restaurant =
	 resimp.getRes(resId);
	 Restaurent res =
	 resimp.getRes(order.getRes_id());

	 List<OrderItem> items =
	 orderitemimpl.getOrderItemsByOrderId(orderId);

	 req.setAttribute("order", order);
	 req.setAttribute("res", res);
	 req.setAttribute("items", items);

	 req.getRequestDispatcher("viewdetail.jsp")
	 .forward(req, resp);
     
     
     
 }
}

