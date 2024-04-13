package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.aspect.ToLogOurApp;
import org.example.dto.CarDto;
import org.example.model.Car;
import org.example.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.module.Configuration;
import java.util.List;

@Controller
@RequiredArgsConstructor

public class CarController {

    private final CarService carService;

    @GetMapping("/car/carlist")
    public String cars(Model model){
        model.addAttribute("cars" , carService.getCarList());
        return "carList";
    }


    @GetMapping("/car/{id}")
    public String carInfo(@PathVariable Long id , Model model ){
        model.addAttribute("car" , carService.getCarById(id));
        return "carInfo";
    }

    @GetMapping("/car/buycar/{id}")
       public String buyCar(@PathVariable Long id , Model model){
        model.addAttribute("message" , carService.buyCar(id));
        return "message";
    }

//    @RequestMapping("/car/buycar/{id}")
//    public String buyCar(@PathVariable Long id){
//        carService.buyCar(id);
//        return "redirect:/";
//    }

    @PostMapping("/car/createcar")
    public String createCar(Car car){
        carService.createCar(car);
        return "redirect:/";
    }

    @GetMapping("/car/confirm/{id}")
    public String confirm(@PathVariable Long id , Model model){
        model.addAttribute("carID" , carService.getCarById(id).getCarID());
        return "confirm";
    }


    @GetMapping("/car/deletecar/{id}")
    public String deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
        return "redirect:/";

    }


    @GetMapping("/addcarpage")
    public String addCarPage(){
        return "addCarPage";
    }


//
//    @PostMapping("/car/addcar")
//    @ToLogOurApp
//    public String addcar(@RequestBody CarDto carDto){
//        return carService.addCar(carDto);
//    }
//


}
