package com.parking.parkinglot1.servlets.cars;

import com.parking.parkinglot1.common.CarDto;
import com.parking.parkinglot1.ejb.CarsBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Cars", value = "/Cars")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"read", "write"}))
public class Cars extends HttpServlet {
    @Inject
    CarsBean carsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRemoteUser() == null) {
            response.sendRedirect(request.getContextPath() + "/Login");
            return;
        }

        List<CarDto> cars = carsBean.findAllCars();
        int numberOfFreeParkingSpots = 10 - cars.size();
        request.setAttribute("cars", cars);
        request.setAttribute("numberOfFreeParkingSpots", numberOfFreeParkingSpots);

        request.getRequestDispatcher("WEB-INF/pages/cars/cars.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRemoteUser() == null) {
            response.sendRedirect(request.getContextPath() + "/Login");
            return;
        }

        String[] carIdsAsString = request.getParameterValues("car_ids");
        if (carIdsAsString != null) {
            List<Long> carIds = new ArrayList<>();
            for (String carIdAsString : carIdsAsString) {
                carIds.add(Long.parseLong(carIdAsString));
            }
            carsBean.deleteCarsByIds(carIds);
        }
        response.sendRedirect(request.getContextPath() + "/Cars");
    }
}