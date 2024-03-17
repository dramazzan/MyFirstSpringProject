package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.model.Car;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CarDto {

    private Long carID;
    private String brand;
    private String model;
    private int year;
    private String color;
    private int price;
    private int amount;



}
