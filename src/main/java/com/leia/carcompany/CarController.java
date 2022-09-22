package com.leia.carcompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/add")
    public Car addCar(@RequestBody Car car){
        return carService.addCar(car);
    }

    @GetMapping("/get/{id}")
    public Car getCar(@PathVariable Long id){
        return carService.getCar(id);
    }

    @GetMapping("/getAll")
    public List<Car> getAll(){
        return carService.getAllCars();
    }

    @DeleteMapping("/delete/param/")
    public void deleteCar(@RequestParam Long id ){
        carService.deleteCar(id);
    }

    @PutMapping("/update/param/")
    public Car updateCar(@RequestParam Long id , @RequestBody Car car){
        return carService.updateCar(id, car);
    }

}
