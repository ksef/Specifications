package com.example.specificationsworkshop.repository;

import com.example.specificationsworkshop.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CarRepository extends JpaRepository<Car, Integer>, JpaSpecificationExecutor<Car> {
}
