package com.example.specificationsworkshop.service;

import com.example.specificationsworkshop.models.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Service {

    Car createNewCar (Car car);

    Page<Car> search (String searchQuery, Pageable pageable);
}
