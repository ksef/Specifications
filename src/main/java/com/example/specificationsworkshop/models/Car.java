package com.example.specificationsworkshop.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "workshop_cars")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String model;
    String engineModel;
    String cylinderVolume;
    LocalDateTime creationDateTime;
    int vinCode;
}
