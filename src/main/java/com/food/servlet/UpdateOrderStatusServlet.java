package com.food.servlet;

import java.io.IOException;

import com.tap.UserDAO.Ordersimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateOrderStatus")
public class UpdateOrderStatusServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        int order_id =
                Integer.parseInt(req.getParameter("order_id"));

        String status =
                req.getParameter("status");

        Ordersimpl dao = new Ordersimpl();

        dao.updateOrderStatus(order_id, status);

        resp.sendRedirect("manageOrders");

    }

}