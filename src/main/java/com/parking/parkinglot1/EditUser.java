package com.parking.parkinglot1;

import com.parking.parkinglot1.entities.User;
import com.parking.parkinglot1.ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EditUser", value = "/EditUser")
public class EditUser extends HttpServlet {

    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("id"));
        User user = userBean.findById(userId);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/pages/editUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        User user = userBean.findById(userId);
        user.setUsername(name);

        if (password != null && !password.isEmpty()) {
            user.setPassword(password);
        }

        userBean.updateUser(user);
        response.sendRedirect(request.getContextPath() + "/Users");
    }
}