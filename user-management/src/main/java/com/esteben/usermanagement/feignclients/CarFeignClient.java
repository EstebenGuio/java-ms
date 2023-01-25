package com.esteben.usermanagement.feignclients;

import com.esteben.usermanagement.model.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@FeignClient(name = "car-management-ms", url = "http://0.0.0.0:8002", path = "/cars")
public interface CarFeignClient {
    @PostMapping
    Car save(@RequestBody Car car);

    @GetMapping("/uid/{uid}")
    List<Car> getCarsByUid(@PathVariable int uid);
}
