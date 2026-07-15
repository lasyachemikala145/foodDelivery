package com.food.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.UserDAO.OrderItemImpl;
import com.tap.UserDAO.Ordersimpl;
import com.tap.model.OrderItem;
import com.tap.model.Orders;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewOrder")
public class ViewOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int order_id = Integer.parseInt(req.getParameter("order_id"));

        Ordersimpl orderDAO = new Ordersimpl();
        OrderItemImpl itemDAO = new OrderItemImpl();

        Orders order = orderDAO.getOrder(order_id);

        List<OrderItem> orderItemList =
                itemDAO.getOrderItemsByOrderId(order_id);

        req.setAttribute("order", order);
        req.setAttribute("orderItemList", orderItemList);

        req.getRequestDispatcher("orderDetail.jsp")
                .forward(req, resp);
    }
}