package com.esteben.bikemanagement.service;

import com.esteben.bikemanagement.entity.Bike;
import com.esteben.bikemanagement.repository.IBikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    @Autowired
    IBikeRepository bikeRepository;

    public List<Bike> getAll() {
        return bikeRepository.findAll();
    }

    public Bike getById(int id) {
        return bikeRepository.findById(id).orElse(null);
    }

    public Bike save(Bike bike) {
        return bikeRepository.save(bike);
    }

    public List<Bike> findByUid(int uid) {
        return bikeRepository.findByUid(uid);
    }
}
