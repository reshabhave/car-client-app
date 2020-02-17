package com.ubs.carclientapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {
    private Integer carId;
    private String carName;
    private double price;
    private String model;
    private Integer yearOfManufacture;
    private String fuelType;

    public Car() {}

    public Car(String carName, double price, String model, Integer yearOfManufacture, String fuelType){
        this.carName = carName;
        this.price = price;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.fuelType = fuelType;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Integer yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }


}
