package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.CarDto;
import org.example.model.Car;
import org.example.repository.CarRepository;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository repository;

    public List<Car> getCarList() {
        return repository.findAll();
    }

    public String addCar(CarDto carDto){
        try {
            Car car = new Car();
            car.setBrand(carDto.getBrand());
            car.setModel(carDto.getModel());
            car.setYear(carDto.getYear());
            car.setColor(carDto.getColor());
            car.setPrice(carDto.getPrice());
            repository.save(car);
        }catch (Exception e){
            return "Not ADDED" + e.getMessage();
        }
        return "Car ADDED Successfully";
    }

    public String createCar(Car car) {
        repository.save(car);
        return "Car ADDED Successfully";
    }

    public String deleteCar(Long id) {
        repository.deleteById(id);
        return "Car DELETED Succussully";
    }

    public Car getCarById(Long id) {
        return repository.findById(id).orElse(null);
    }


    public String buyCar(Long id) {
        Car car = getCarById(id);
        if (car != null) {
            int currentAmount = car.getAmount();
            if (currentAmount > 0) {
                car.setAmount(currentAmount - 1);
                repository.save(car);
                return "Your Successfully bought "+car.getBrand()+" "+car.getModel()+"!";
            } else {
                return car.getBrand()+" "+car.getModel()+" is over!";
            }
        } else {
            return "Car not found!";
        }
    }




}
