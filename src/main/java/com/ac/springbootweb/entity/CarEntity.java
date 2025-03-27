package com.ac.springbootweb.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String chassis;
    private String color;
    private int year;
    private String plate;

}
