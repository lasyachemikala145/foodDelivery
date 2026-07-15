package com.food.servlet;

import java.io.IOException;

import com.tap.UserDAO.MenuDAOimp;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Menu;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
@WebServlet("/callCartServlet")
public class CartServlet extends HttpServlet{

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	System.out.print("cartservlet");	//intially we add cart to session
	HttpSession session = req.getSession();
	Cart cart=(Cart)session.getAttribute("cart");
	//in the request there will be some parameter 
	//we are getting cart,restaurant id from the session 
	Integer oldRestaurantId =
			(Integer) session.getAttribute("restaurantId");
	//we are getting request object from the req
	int newRestaurantId =
			Integer.parseInt(req.getParameter("res_id"));

	if(cart == null) {

		cart = new Cart();

		session.setAttribute("cart", cart);
		session.setAttribute("restaurantId", newRestaurantId);
	}
	else if(oldRestaurantId != null &&
			oldRestaurantId != newRestaurantId) {

		cart = new Cart();

		session.setAttribute("cart", cart);
		session.setAttribute("restaurantId", newRestaurantId);
	}
	String action=req.getParameter("action");
	if(action.equals("add")) {
		addItemToCart(req,cart);
	}
	else if(action.equals("update")) {
		updateItemToCart(req,cart);
	}
	else if(action.equals("remove")) {
		// TODO Auto-generated method stub
		removeItemFromCart(req,cart);
		
	}
	resp.sendRedirect("cart.jsp");
}
private void addItemToCart(HttpServletRequest req,Cart cart) {
	int menuId=Integer.parseInt(req.getParameter("menu_id"));
	int quantity=Integer.parseInt(req.getParameter("quantity"));
	MenuDAOimp menuDAoImpl=new MenuDAOimp();
	Menu menu=menuDAoImpl.getMenu(menuId);
	System.out.println("Menu ID = " + menuId);
	//using menu id we are feting the details of the menu id 
	//to get menu info of a particular id we use getMenu()->present in implementation part
	CartItem cartitem=new CartItem(menu.getMenu_id(),menu.getRes_id(),menu.getNameofitem(),menu.getPrice(),quantity);
	//we send these details to the cart item
	//from menu.jsp->cartServlet(use menu id and get deatils from menu implemnetation)->send to cart item
	cart.addItem(cartitem);

}
private void updateItemToCart(HttpServletRequest req,Cart cart) {
	int menuId=Integer.parseInt(req.getParameter("menu_id"));
	int quantity=Integer.parseInt(req.getParameter("quantity"));
	cart.updateItem(menuId,quantity);

}
private void removeItemFromCart(HttpServletRequest req,Cart cart) {
	int menuId=Integer.parseInt(req.getParameter("menu_id"));
	cart.removeItemFromCart(menuId);
}



}


