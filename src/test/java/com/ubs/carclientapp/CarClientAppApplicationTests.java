package com.ubs.carclientapp;

import com.ubs.carclientapp.model.Car;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarClientAppApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort()
    int randomServerPort;

    @Value("${car.master.URL}")
    private String serviceURL;

    @Test
    public void testGetCar() throws URISyntaxException {
        final String baseUrl = serviceURL + "1";
        URI uri = new URI(baseUrl);
        ResponseEntity<Car> result = this.restTemplate.getForEntity(uri, Car.class);
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals("MarutiSuzuki", result.getBody().getCarName());
    }

    @Test
    public void testGetCarWithException() throws URISyntaxException {
        final String baseUrl = serviceURL + "10";
        URI uri = new URI(baseUrl);
        ResponseEntity<Car> result = this.restTemplate.getForEntity(uri, Car.class);
        Assert.assertEquals(404, result.getStatusCodeValue());
        Assert.assertEquals(null, result.getBody().getCarName());
    }

}
