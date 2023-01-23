package com.esteben.carmanagement.repository;

import com.esteben.carmanagement.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByUid(int uid);

}
