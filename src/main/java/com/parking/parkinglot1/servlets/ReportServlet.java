package com.parking.parkinglot1.servlets;

import com.parking.parkinglot1.ejb.UserBean;
import com.parking.parkinglot1.entities.Car;
import com.parking.parkinglot1.entities.User;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;

@WebServlet("/Report")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"read", "write"}))
public class ReportServlet extends HttpServlet {
    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userBean.findAllUsersWithCars();
        Map<User, List<Car>> userCarsMap = users.stream()
                .collect(Collectors.toMap(user -> user, user -> new ArrayList<>(user.getCars())));

        request.setAttribute("userCarsMap", userCarsMap);
        request.getRequestDispatcher("/WEB-INF/pages/users/report.jsp").forward(request, response);
    }
}