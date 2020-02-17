package com.ubs.carclientapp.controller;

import com.ubs.carclientapp.model.Car;
import com.ubs.carclientapp.service.CarClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CarClientController {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    CarClientService carClientService;

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarDetails(@PathVariable(value = "id") Integer carId) {
        Car carDetails = carClientService.getCar(carId);
        return ResponseEntity.ok().body(carDetails);
    }
}
