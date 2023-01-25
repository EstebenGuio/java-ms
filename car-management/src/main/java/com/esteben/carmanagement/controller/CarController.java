package com.esteben.carmanagement.controller;

import com.esteben.carmanagement.entity.Car;
import com.esteben.carmanagement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAll() {
        List<Car> cars = carService.getAll();
        if (cars.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{cid}")
    public ResponseEntity getById(@PathVariable int cid) {
        Car car = carService.getById(cid);
        if (car == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(car);
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car) {
        return ResponseEntity.ok(carService.save(car));
    }

    @GetMapping("/uid/{uid}")
    public ResponseEntity<List<Car>> findByUid(@PathVariable int uid) {
        List<Car> cars = carService.findByUid(uid);
        return ResponseEntity.ok(cars);
    }

}
