package com.food.servlet;

import java.io.IOException;

import com.tap.UserDAO.MenuDAOimp;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editMenu")
public class EditMenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int menu_id = Integer.parseInt(req.getParameter("menu_id"));

        MenuDAOimp dao = new MenuDAOimp();

        Menu menu = dao.getMenu(menu_id);

        req.setAttribute("menu", menu);

        req.getRequestDispatcher("editMenu.jsp").forward(req, resp);
    }
}