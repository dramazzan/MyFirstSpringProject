package org.example.service;

import jakarta.transaction.Transaction;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.Car;
import org.example.model.Image;
import org.example.repository.CarRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarService {

    private final CarRepository repository;


    public List<Car> getCarList() {
        return repository.findAll();
    }

    @Transactional
    public void saveCar(Car car, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        System.out.println(file1);
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            car.addImageToCar(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            car.addImageToCar(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            car.addImageToCar(image3);
        }
        Car carFromDb = repository.save(car);
        carFromDb.setPreviewImageId(carFromDb.getImages().get(0).getId());
        repository.save(carFromDb);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setOriginalFileName(new String(file.getOriginalFilename().getBytes("UTF-8"), "UTF-8")); // Устанавливаем правильную кодировку
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }


//    public String addCar(CarDto carDto){
//        try {
//            Car car = new Car();
//            car.setBrand(carDto.getBrand());
//            car.setModel(carDto.getModel());
//            car.setYear(carDto.getYear());
//            car.setColor(carDto.getColor());
//            car.setPrice(carDto.getPrice());
//            car.setAmount(carDto.getAmount());
//            car.setClient(carDto.getClient());
//            repository.save(car);
//        }catch (Exception e){
//            return "Not ADDED" + e.getMessage();
//        }
//        return "Car ADDED Successfully";
//    }


    public void deleteCar(Long id) {
        repository.deleteById(id);
    }

    public Car getCarById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public String buyCar(Long id) {
        Car car = getCarById(id);
        if (car != null) {
            int currentAmount = car.getAmount();
            if (currentAmount > 0) {
                car.setAmount(currentAmount - 1);
                repository.save(car);
                return "Your Successfully bought " + car.getBrand() + " " + car.getModel() + "!";
            } else {
                return car.getBrand() + " " + car.getModel() + " is over!";
            }
        } else {
            return "Car not found!";
        }


    }


}
