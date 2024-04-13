package org.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "car_table")
@Data
@RequiredArgsConstructor
public class Car {
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

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "car")
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;
    private LocalDateTime dateOfCreated;

    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }


    public void addImageToCar(Image img) {
        img.setCar(this);
        images.add(img);
    }

}
