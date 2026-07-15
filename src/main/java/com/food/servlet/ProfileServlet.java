package com.food.servlet;

import java.io.IOException;

import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if(session == null) {

            resp.sendRedirect("login.jsp");
            return;
        }

        User user = (User)session.getAttribute("user");

        if(user == null) {

            resp.sendRedirect("login.jsp");
            return;
        }

        req.setAttribute("user", user);

        req.getRequestDispatcher("profile.jsp")
        .forward(req, resp);

    }

}