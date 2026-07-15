package com.food.servlet;

import java.io.IOException;

import com.tap.UserDAO.MenuDAOimp;
import com.tap.UserDAO.Ordersimpl;
import com.tap.model.RestaurantAdmin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminDashboard")
public class AdminDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if(session == null || session.getAttribute("admin") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        RestaurantAdmin admin =
                (RestaurantAdmin) session.getAttribute("admin");

        int res_id = admin.getRestaurant_id();

        Ordersimpl orderDAO = new Ordersimpl();
        MenuDAOimp menuDAO = new MenuDAOimp();

        req.setAttribute("totalOrders",
                orderDAO.getTotalOrders(res_id));

        req.setAttribute("pendingOrders",
                orderDAO.getPendingOrders(res_id));

        req.setAttribute("deliveredOrders",
                orderDAO.getDeliveredOrders(res_id));

        req.setAttribute("totalRevenue",
                orderDAO.getTotalRevenue(res_id));

        req.setAttribute("totalMenuItems",
                menuDAO.getTotalMenuItems(res_id));

        req.getRequestDispatcher("adminDashboard.jsp")
                .forward(req, resp);

    }
}