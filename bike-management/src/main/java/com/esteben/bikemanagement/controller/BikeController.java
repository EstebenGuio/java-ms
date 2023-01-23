package com.esteben.bikemanagement.controller;

import com.esteben.bikemanagement.entity.Bike;
import com.esteben.bikemanagement.service.BikeService;
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
@RequestMapping("/bikes")
public class BikeController {

    @Autowired
    BikeService bikeService;

    @GetMapping
    public ResponseEntity<List<Bike>> getAll() {
        List<Bike> bikes = bikeService.getAll();
        if (bikes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(bikes);
    }

    @GetMapping("/{bid}")
    public ResponseEntity<Bike> getById(@PathVariable int bid) {
        Bike bike = bikeService.getById(bid);
        if (bike == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(bike);
    }

    @GetMapping("/uid/{uid}")
    public ResponseEntity<List<Bike>> getByUid(@PathVariable int uid) {
        List<Bike> bikes = bikeService.findByUid(uid);
        if (bikes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(bikes);
    }

    @PostMapping
    public ResponseEntity<Bike> save(@RequestBody Bike bike) {
        Bike newBike = bikeService.save(bike);
        if (newBike == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(newBike);
    }
}
