package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

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
    @Column (unique = true)
    private String email;
    @Column(unique = true)
    private String phoneNumber;

    @OneToMany(mappedBy = "client")
    private List<Car> carList ;

}
