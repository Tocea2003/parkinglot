package com.parking.parkinglot1;

import com.parking.parkinglot1.common.CarDto;
import com.parking.parkinglot1.ejb.CarsBeans;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
@MultipartConfig

@WebServlet(name = "AddCarPhoto", value = "/AddCarPhoto")
public class AddCarPhoto extends HttpServlet {

    @Inject
    CarsBeans carsBeans;

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String carIdParam = request.getParameter("id");
    if (carIdParam != null) {
        try {
            Long carId = Long.parseLong(carIdParam);
            CarDto car = carsBeans.findById(carId);
            request.setAttribute("car", car);
            request.getRequestDispatcher("/WEB-INF/pages/addCarPhoto.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid car ID");
        }
    } else {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Car ID is required");
    }
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String carIdParam = request.getParameter("id");
    if (carIdParam != null) {
        try {
            Long carId = Long.parseLong(carIdParam);
            Part filePart = request.getPart("file");
            String filename = filePart.getSubmittedFileName();
            String fileType = filePart.getContentType();
            long fileSize = filePart.getSize();
            byte[] fileContent = new byte[(int) fileSize];
            filePart.getInputStream().read(fileContent);
            carsBeans.addPhotoToCar(carId, filename, fileType, fileContent);
            response.sendRedirect(request.getContextPath() + "/Cars");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid car ID");
        }
    } else {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Car ID is required");
    }
}
}
