package com.ubs.carclientapp.service;

import com.ubs.carclientapp.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class CarClientService {
    @Autowired
    private final RestTemplate restTemplate;
    private CircuitBreakerFactory circuitBreakerFactory;

    public CarClientService(RestTemplate rest, CircuitBreakerFactory circuitBreakerFactory) {
        this.restTemplate = rest;
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    public Car getCar(Integer carId){
        URI uri = URI.create("http://localhost:8080/carmaster-example/api/cars/" + carId);
        return circuitBreakerFactory.create("getCar").run(() ->
                this.restTemplate.getForObject(uri, Car.class),
                throwable -> recoveryMethod(carId));
    }

    public Car recoveryMethod(Integer carId){
        System.out.println("There was an error gettingCar from Car Master service");
        return new Car();
    }
}
