package com.parking.parkinglot1.rest;

import com.parking.parkinglot1.common.CarDto;
import com.parking.parkinglot1.ejb.CarsBeans;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/cars")
@RolesAllowed("READ_CARS")
public class CarsController {

    @Inject
    CarsBeans carsBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CarDto> findAllCars() {
        return carsBean.findAllCars();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CarDto findCar(@PathParam("id") Long id) {
        return carsBean.findById(id);
    }
}