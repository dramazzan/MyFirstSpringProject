package org.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "car_table")
@Data
@RequiredArgsConstructor
public class Car{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long carID;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private int year;
    @Column(name = "color")
    private String color;
    @Column(name = "price")
    private int price;
    @Column(name = "amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


}
