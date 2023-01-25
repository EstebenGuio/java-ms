package com.esteben.usermanagement.service;

import com.esteben.usermanagement.entity.User;
import com.esteben.usermanagement.feignclients.BikeFeignClient;
import com.esteben.usermanagement.feignclients.CarFeignClient;
import com.esteben.usermanagement.model.Bike;
import com.esteben.usermanagement.model.Car;
import com.esteben.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CarFeignClient carFeignClient;

    @Autowired
    private BikeFeignClient bikeFeignClient;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {
        return userRepository.save(user);
    }


    /**
     * Using rest template for ms communication
     *
     * @param {int} id
     * @return {car} car obj
     */
    public List<Car> getCarsRT(int id) {
        List<Car> cars = restTemplate.getForObject("http://0.0.0.0:8002/cars/uid/" + id, List.class);
        return cars;
    }

    /**
     * Using rest template for ms communication
     *
     * @param {int} id
     * @return {Bike} bike obj
     */
    public List<Bike> getBikesRT(int id) {
        List<Bike> bikes = restTemplate.getForObject("http://0.0.0.0:8001/bikes/uid/" + id, List.class);
        return bikes;
    }


    /**
     * Using feign client for ms communication
     *
     * @param uid
     * @param car
     * @return {Car} car obj
     */
    public Car saveCarFeign(int uid, Car car) {
        car.setUid(uid);
        return carFeignClient.save(car);
    }

    /**
     * Using feign client for ms communication
     *
     * @param uid
     * @param bike
     * @return {Bike} bike obj
     */
    public Bike saveBikeFeign(int uid, Bike bike) {
        bike.setUid(uid);
        return bikeFeignClient.save(bike);
    }

    public Map<String, Object> userVehicles(int uid) {
        Map<String, Object> result = new HashMap<>();
        User user = userRepository.findById(uid).orElse(null);

        if (user == null) {
            result.put("Result", "user does not exist");
            return result;
        }

        result.put("user", user);

        List<Car> cars = carFeignClient.getCarsByUid(uid);
        if (cars.isEmpty())
            result.put("cars", "user has not cars");
        else
            result.put("cars", cars);

        List<Bike> bikes = bikeFeignClient.getBikesByUid(uid);
        if (bikes.isEmpty())
            result.put("bikes", "user has not bikes");
        else
            result.put("bikes", bikes);
        
        return result;
    }
}
