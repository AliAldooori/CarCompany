package com.leia.carcompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private CarRepository carRepository;
     @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car addCar(Car car){
         return carRepository.save(car);
    }

    public Car getCar(Long id){
         return carRepository.findById(id).get();
    }
    public List<Car> getAllCars(){
         return carRepository.findAll();
    }
    public void deleteCar(Long id){
         carRepository.deleteById(id);
    }

    public Car updateCar(Long id , Car car){
        Car savedCar = carRepository.findById(id).get();
        savedCar.setId(car.getId());
        savedCar.setModel(car.getModel());
        savedCar.setYear(car.getYear());
        carRepository.save(savedCar);
        return savedCar;

    }
}
