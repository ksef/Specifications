package com.example.specificationsworkshop.controller;

import com.example.specificationsworkshop.models.Car;
import com.example.specificationsworkshop.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/workshop_cars")
@RequiredArgsConstructor
public class Controller {

    private final Service service;

    @PostMapping()
    public Car createCar(
            @RequestBody Car car) {
        car.setCreationDateTime(LocalDateTime.now());
        return service.createNewCar(car);
    }

    @GetMapping
    public Page<Car> search(@RequestParam String search, Pageable pageable) {
        return service.search(search, pageable);
    }
}
