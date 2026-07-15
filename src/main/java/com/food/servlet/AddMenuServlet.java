package com.food.servlet;

import java.io.IOException;

import com.tap.UserDAO.MenuDAOimp;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addMenu")
public class AddMenuServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nameofitem = req.getParameter("nameofitem");
        float price = Float.parseFloat(req.getParameter("price"));
        float rating = Float.parseFloat(req.getParameter("rating"));
        String category = req.getParameter("category");
        String imgurl = req.getParameter("imgurl");
        int res_id = Integer.parseInt(req.getParameter("res_id"));

        Menu menu = new Menu();

        menu.setNameofitem(nameofitem);
        menu.setPrice(price);
        menu.setRating(rating);
        menu.setCategory(category);
        menu.setImgurl(imgurl);
        menu.setRes_id(res_id);

        MenuDAOimp dao = new MenuDAOimp();

        dao.addMenuByAdmin(menu);

        resp.sendRedirect("manageMenu");
    }
}