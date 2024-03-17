package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.CarDto;
import org.example.dto.ClientDto;
import org.example.model.Car;
import org.example.model.Client;
import org.example.repository.ClientRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.Caret;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository repository;


    public List<Client> getClientList(){
        return repository.findAll();
    }

    public String addClient(Client client){
            repository.save(client);
            return "Client ADDED Successfully";
    }

    public String deleteClient(Long id){
        repository.deleteById(id);
        return "Client DELETED Successfully";
    }

    public Client getClientByID(Long id){
        return repository.findById(id).orElse(null);
    }


    public String createClient(ClientDto clientDto){
        try {
            Client client = new Client();
            client.setClientName(clientDto.getClientName());
            client.setAge(clientDto.getAge());
            client.setEmail(clientDto.getEmail());
            client.setPhoneNumber(clientDto.getPhoneNumber());

            repository.save(client);
        }catch (Exception e){
            return "Not ADDED" + e.getMessage();
        }
        return "Client ADDED Successfully";
    }






}
