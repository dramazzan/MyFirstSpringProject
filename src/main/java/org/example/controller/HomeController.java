package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.CarDto;
import org.example.model.Car;
import org.example.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final CarService carService;
    @GetMapping("/cars")
    public List<Car> getAllCar(){
        return carService.getCarList();
    }

    @GetMapping("/car/{id}")
    public Car carInfo(@PathVariable Long id){
        return carService.getCarById(id);
    }

    @GetMapping("/buycar/{id}")
    public String buyCar(@PathVariable Long id){
        return carService.buyCar(id);
    }
    @PostMapping("/createcar")
    public String createCar(@RequestBody Car car){
       return carService.createCar(car);
    }

    @PostMapping("/deletecar/{id}")
    public String deleteCar(@RequestBody Long id){
        return carService.deleteCar(id);

    }

    @PostMapping("/addcar")
    public String addcar(@RequestBody CarDto carDto){
        return carService.addCar(carDto);
    }







}
