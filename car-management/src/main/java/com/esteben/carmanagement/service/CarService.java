package com.esteben.carmanagement.service;

import com.esteben.carmanagement.entity.Car;
import com.esteben.carmanagement.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    ICarRepository carRepository;

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Car getById(int cid) {
        return carRepository.findById(cid).orElse(null);
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public List<Car> findByUid(int uid) {
        return carRepository.findByUid(uid);
    }
}
