package com.example.springcriteria.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author extends Identity{
    @Getter
    @Setter
    @Column(nullable = false, length = 50)
    private String name;

    @Getter
    @Setter
    @Column(nullable = false)
    private int age;

    @Getter
    @Setter
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Set<Article> articles = new HashSet<>();

}
