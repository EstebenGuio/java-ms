package com.esteben.usermanagement.feignclients;

import com.esteben.usermanagement.model.Bike;
import com.esteben.usermanagement.model.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(name = "bike-management-ms", url = "http://0.0.0.0:8001", path = "/bikes")
public interface BikeFeignClient {
    @PostMapping
    Bike save(@RequestBody Bike bike);

    @GetMapping("/uid/{uid}")
    List<Bike> getBikesByUid(@PathVariable int uid);
}
