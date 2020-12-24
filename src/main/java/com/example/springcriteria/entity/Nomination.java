package com.example.springcriteria.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Nomination extends Identity{
    @Getter
    @Setter
    @Column(nullable = false, length = 150)
    private String name;
}
