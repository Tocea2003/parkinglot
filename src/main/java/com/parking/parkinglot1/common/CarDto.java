package com.parking.parkinglot1.common;

import com.parking.parkinglot1.entities.CarPhoto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;

public class CarDto {
    private Long id;
    private String licensePlate;
    private String parkingSpot;
    private String ownerName;
    private String owner; // Add this property
    private CarPhoto photo; // Add this property

    // Constructors
    public CarDto(Long id, String licensePlate, String parkingSpot, String ownerName, String owner) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.parkingSpot = parkingSpot;
        this.ownerName = ownerName;
        this.owner = owner;
    }




    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(String parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}