package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Car;
import org.example.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor

public class CarController {

    private final CarService carService;

    @GetMapping("/car/carlist")
    public String cars(Model model) {
        model.addAttribute("cars", carService.getCarList());
        return "carList";
    }


    @GetMapping("/car/{id}")
    public String carInfo(@PathVariable Long id, Model model) {
        Car car = carService.getCarById(id);
        model.addAttribute("car", carService.getCarById(id));
        model.addAttribute("images", car.getImages());
        return "carInfo";
    }

    @GetMapping("/car/buycar/{id}")
    public String buyCar(@PathVariable Long id, Model model) {
        model.addAttribute("message", carService.buyCar(id));
        return "message";
    }


    @PostMapping("/car/create")
    public String createCar(@RequestParam("file1") MultipartFile file1,
                            @RequestParam("file2") MultipartFile file2,
                            @RequestParam("file3") MultipartFile file3,
                            @ModelAttribute Car car) throws IOException {
        carService.saveCar(car, file1, file2, file3);
        return "redirect:/";
    }

    @GetMapping("/car/confirm/{id}")
    public String confirm(@PathVariable Long id, Model model) {
        model.addAttribute("carID", carService.getCarById(id).getCarID());
        return "confirm";
    }


    @GetMapping("/car/deletecar/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return "redirect:/car/carlist";

    }


    @GetMapping("/addcarpage")
    public String addCarPage() {
        return "addCarPage";
    }


}
