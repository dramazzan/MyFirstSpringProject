package org.example.controller;

import lombok.RequiredArgsConstructor;

import org.example.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequiredArgsConstructor
public class HomeController {

    private final CarService carService;

    @GetMapping("/")
    public String homepage(Model model){
        model.addAttribute("cars", carService.getCarList());
        return "homePage";
    }


    @GetMapping("/profile")
    public String profile(Model model) {
        return "profile";
    }






}
