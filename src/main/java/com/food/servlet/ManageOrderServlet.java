package com.food.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.UserDAO.Ordersimpl;
import com.tap.model.Orders;
import com.tap.model.RestaurantAdmin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/manageOrders")
public class ManageOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        RestaurantAdmin admin =
                (RestaurantAdmin) session.getAttribute("admin");

        if (admin == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        int res_id = admin.getRestaurant_id();

        Ordersimpl dao = new Ordersimpl();

        List<Orders> orderList = dao.getOrdersByRestaurant(res_id);

        req.setAttribute("orderList", orderList);

        req.getRequestDispatcher("manageOrders.jsp")
                .forward(req, resp);
    }
}