package com.esteben.usermanagement.service;

import com.esteben.usermanagement.entity.User;
import com.esteben.usermanagement.model.Bike;
import com.esteben.usermanagement.model.Car;
import com.esteben.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<Car> getCars(int id) {
        List<Car> cars = restTemplate.getForObject("http://0.0.0.0:8002/cars/uid/" + id, List.class);
        return cars;
    }

    public List<Bike> getBikes(int id) {
        List<Bike> bikes = restTemplate.getForObject("http://0.0.0.0:8001/bikes/uid/" + id, List.class);
        return bikes;
    }
}
