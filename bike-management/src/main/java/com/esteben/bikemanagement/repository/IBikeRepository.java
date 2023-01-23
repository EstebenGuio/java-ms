package com.esteben.bikemanagement.repository;

import com.esteben.bikemanagement.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBikeRepository extends JpaRepository<Bike, Integer> {

    List<Bike> findByUid(int uid);
}
