package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private Long clientID;
    private String clientName;
    private int age;
    private String email;
    private String phoneNumber;


}
