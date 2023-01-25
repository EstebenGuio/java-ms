package com.esteben.usermanagement.controller;

import com.esteben.usermanagement.entity.User;
import com.esteben.usermanagement.model.Bike;
import com.esteben.usermanagement.model.Car;
import com.esteben.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAll();
        if (users.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") int id) {
        User user = userService.getById(id);
        if (user == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User userNew = userService.save(user);
        return ResponseEntity.ok(userNew);

    }

    @GetMapping("/rt/cars/{uid}")
    public ResponseEntity<List<Car>> getCarsRT(@PathVariable int uid) {
        List<Car> cars = userService.getCarsRT(uid);
        if (cars == null || cars.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cars);
    }


    @GetMapping("/rt/bikes/{uid}")
    public ResponseEntity<List<Bike>> getBikesRT(@PathVariable int uid) {
        List<Bike> bikes = userService.getBikesRT(uid);
        if (bikes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(bikes);
    }

    @PostMapping("/feign/car/{uid}")
    public ResponseEntity<Car> saveCarFeign(@PathVariable int uid, @RequestBody Car car) {
        Car carnew = userService.saveCarFeign(uid, car);
        return ResponseEntity.ok(carnew);
    }

    @PostMapping("/feign/bike/{uid}")
    public ResponseEntity<Bike> saveBikeFeign(@PathVariable int uid, @RequestBody Bike bike) {
        Bike bikeNew = userService.saveBikeFeign(uid, bike);
        return ResponseEntity.ok(bikeNew);
    }

    @GetMapping("/getall/{uid}")
    public ResponseEntity<Map<String, Object>> getUserVehicles(@PathVariable int uid) {
        Map<String, Object> result = userService.userVehicles(uid);
        return ResponseEntity.ok(result);
    }
}
