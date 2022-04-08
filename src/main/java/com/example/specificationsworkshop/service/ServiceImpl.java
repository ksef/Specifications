package com.example.specificationsworkshop.service;

import com.example.specificationsworkshop.models.Car;
import com.example.specificationsworkshop.repository.CarRepository;
import com.example.specificationsworkshop.repository.specification.CarSpecificationBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ServiceImpl implements com.example.specificationsworkshop.service.Service {

    private final CarRepository carRepository;

    @Override
    public Car createNewCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Page<Car> search(String searchQuery, Pageable pageable) {
        CarSpecificationBuilder builder = new CarSpecificationBuilder(searchQuery);
        Specification<Car> specification = builder.build().orElseThrow();
        return carRepository.findAll(specification, pageable);
    }
}

