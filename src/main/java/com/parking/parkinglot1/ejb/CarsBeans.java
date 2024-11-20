package com.parking.parkinglot1.ejb;
import com.parking.parkinglot1.common.CarDto;
import com.parking.parkinglot1.entities.Car;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CarsBeans {

    private static final Logger LOG = Logger.getLogger(CarsBeans.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<CarDto> findAllCars(){
        LOG.info("Finding all cars");
        try {
            TypedQuery<Car> typedQuery=entityManager.createQuery("SELECT c FROM Car c",Car.class);
            List<Car> cars=typedQuery.getResultList();
            return copyCarsToDto(cars);
        }
        catch (Exception e){
            throw new EJBException(e);
        }
    }

    private List<CarDto> copyCarsToDto(List<Car> cars) {
        List<CarDto> carDtos = new ArrayList<>();
        for (Car car : cars) {
            CarDto carDto = new CarDto(
                    car.getId(),
                    car.getLicensePlate(),
                    car.getParkingSpot(),
                    car.getOwner().getUsername(),
                    car.getOwner().getUsername() // Assuming owner and ownerName are the same
            );
            carDtos.add(carDto);
        }
        return carDtos;
    }
}