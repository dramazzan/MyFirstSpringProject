package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "client_table")
public class Client {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long clientID;
    @Column(name = "name")
    private String clientName;
    @Column(name = "age")
    private int age;
    @Column(name = "email")
    private String email;
    @Column(name = "number")
    private String phoneNumber;
}
