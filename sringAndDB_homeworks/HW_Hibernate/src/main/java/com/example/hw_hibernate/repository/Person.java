package com.example.hw_hibernate.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    private String name;
    private String surename;
    private int age;

    private long phoneNumber;

    @Column(nullable = false)
    private String cityOfLiving;

}
