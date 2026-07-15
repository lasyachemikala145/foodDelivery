package com.food.servlet;

import java.io.IOException;

import com.tap.UserDAO.MenuDAOimp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteMenu")
public class DeleteMenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int menu_id = Integer.parseInt(req.getParameter("menu_id"));

        MenuDAOimp dao = new MenuDAOimp();

        dao.delteMenu(menu_id);

        resp.sendRedirect("manageMenu");
    }
}