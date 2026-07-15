package com.food.servlet;

	import java.io.IOException;
	import java.sql.Timestamp;

import com.tap.UserDAO.OrderItemImpl;
import com.tap.UserDAO.Ordersimpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.OrderItem;
import com.tap.model.Orders;
import com.tap.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

	@WebServlet("/CheckoutServlet")
	public class checkoutServlet extends HttpServlet {
	

	    @Override
	    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException {
	    	HttpSession session=req.getSession();
	    	User user=(User)session.getAttribute("user");
	    	//int ResId = (int) session.getAttribute("res_id");
	    	Integer ResId = (Integer) session.getAttribute("restaurantId");

	    	if (ResId == null) {
	    	    res.sendRedirect("cart.jsp");
	    	    return;
	    	}
	    	

	    	System.out.println("User in session: " + session.getAttribute("user"));
	    	Cart cart=(Cart)session.getAttribute("cart");
	    	if(user==null) {
	    	RequestDispatcher	rd=req.getRequestDispatcher("login.jsp");
	    		rd.forward(req,res);
	    	}
	    	if(user!=null && cart!=null && !cart.getItems().isEmpty()) {
	        
	       String deliveryAddress=req.getParameter("deliveryAddress");
	       //getting address from cart.jspbez if user change particular we need to for particular order
	       Orders orders=new Orders();
	       //orders.setRes_id();
	       orders.setDelivery_address(deliveryAddress);
	       //we are setting values checkout->db
	       orders.setUser_id(user.getUser());
	       orders.setRes_id(ResId);
	      Timestamp ts=new Timestamp(System.currentTimeMillis());
	      orders.setOrderdate(ts.toLocalDateTime());
	      String payment = req.getParameter("payment");
	      orders.setPayment(payment);
	      orders.setStatus("pending");
	      String grandTotal = req.getParameter("grandTotal");
	      float finalPrice = Float.parseFloat(grandTotal);
	      orders.setFinalprice(finalPrice);
	       Ordersimpl ordersimpl=new Ordersimpl();
	       //ordersimpl.addOrder(orders);
	       
	       
	       //orderItem
	       int order_id = ordersimpl.addOrder(orders);

	       OrderItemImpl orderitemimpl = new OrderItemImpl();

	       for(CartItem item : cart.getItems().values()) {

	           OrderItem orderItem = new OrderItem();

	           orderItem.setOrder_id(order_id);
	           orderItem.setItemName(item.getName());
	           orderItem.setQuantity(item.getQuantity());
	           orderItem.setPrice(item.getPrice());

	           orderitemimpl.addOrderItem(orderItem);
	       }
	       //OrderItemImpl orderitemimpl=new OrderItemImpl();
	       //orderitemimpl.addOrderItem(orderItem);
	       //after order is placed
	       session.removeAttribute("cart");
	       session.removeAttribute("res_id");
	       //session.removeAttribute("grandTotal");
	       res.sendRedirect("placeorder.jsp");
	    	}
	    	else {
	    		res.sendRedirect("cart.jsp");
	    	}

	    }

	}


