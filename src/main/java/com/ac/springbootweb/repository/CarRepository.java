package com.ac.springbootweb.repository;

import com.ac.springbootweb.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
}
