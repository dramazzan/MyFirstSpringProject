package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.ClientDto;
import org.example.model.Client;
import org.example.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
//
//    @GetMapping("/client/clients")
//    public List<Client> getClientList(){
//        return clientService.getClientList();
//    }
//
//    @GetMapping("/client/{id}")
//    public Client getClientById(@PathVariable Long id){
//        return clientService.getClientByID(id);
//    }
//
//
//    @PostMapping("/client/addclient")
//    public String addCar(@RequestBody Client client){
//        return clientService.addClient(client);
//    }
//
//    @PostMapping("/client/createclient")
//    public String createClient(@RequestBody ClientDto clientDto){
//        return clientService.createClient(clientDto);
//    }
//
//
//



}
