package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.aspect.ToLogOurApp;
import org.example.dto.CarDto;
import org.example.dto.ClientDto;
import org.example.model.Car;
import org.example.model.Client;
import org.example.service.CarService;
import org.example.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final CarService carService;
    private final ClientService clientService;


    @GetMapping("/hello/{name}")
    @ToLogOurApp
    public String hello(@PathVariable String name){
        return "hello"+name+"!";
    }



//    Car Controller

    @GetMapping("car/cars")
    public List<Car> getAllCar(){
        return carService.getCarList();
    }

    @GetMapping("/car/{id}")
    public Car carInfo(@PathVariable Long id){
        return carService.getCarById(id);
    }

    @GetMapping("car/buycar/{id}")
    public String buyCar(@PathVariable Long id){
        return carService.buyCar(id);
    }
    @PostMapping("car/createcar")

    public String createCar(@RequestBody Car car){
       return carService.createCar(car);
    }

    @GetMapping("car/deletecar/{id}")
    public String deleteCar(@PathVariable Long id){
        return carService.deleteCar(id);

    }

    @PostMapping("car/addcar")
    @ToLogOurApp
    public String addcar(@RequestBody CarDto carDto){
        return carService.addCar(carDto);
    }


//    Client Controller

    @GetMapping("client/clients")
    public List<Client> getClientList(){
       return clientService.getClientList();
    }

    @GetMapping("/client/{id}")
    public Client getClientById(@PathVariable Long id){
       return clientService.getClientByID(id);
    }


    @PostMapping("client/addclient")
    public String addCar(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @PostMapping("client/createclient")
    public String createClient(@RequestBody ClientDto clientDto){
        return clientService.createClient(clientDto);
    }





}
