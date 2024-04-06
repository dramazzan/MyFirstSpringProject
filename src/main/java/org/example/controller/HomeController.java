package org.example.controller;

import lombok.RequiredArgsConstructor;

import org.example.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequiredArgsConstructor
public class HomeController {

//    @RequestMapping("/home")
//    public String home(){
//        return "homepage.html";
//    }

    private final CarService carService;

    @GetMapping("/")
    public String cars(Model model){
        model.addAttribute("cars" , carService.getCarList());
        return "home";
    }




}
