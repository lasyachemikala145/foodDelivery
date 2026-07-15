package com.food.servlet;

import java.io.IOException;

import com.tap.UserDAO.UserDAOImpl;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/UpdateAddressServlet")
public class UpdateAddressServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if(session == null) {

            resp.sendRedirect("login.jsp");
            return;
        }

        User user =
        (User)session.getAttribute("user");

        if(user == null) {

            resp.sendRedirect("login.jsp");
            return;
        }

        String newAddress =
                req.getParameter("address");

        UserDAOImpl dao = new UserDAOImpl();

        boolean status =
        dao.updateAddress(user.getUser(), newAddress);

        if(status) {

            user.setAddress(newAddress);

            session.setAttribute("user", user);
            

            resp.sendRedirect("ProfileServlet");

        }
        else {

            resp.sendRedirect("editAddress.jsp");

        }

    }

}