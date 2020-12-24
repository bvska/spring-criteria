package com.example.springcriteria.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Article extends Identity{
    @Getter
    @Setter
    @Column(nullable = false, length = 100)
    private String title;

    @Getter
    @Setter
    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;

    @Getter
    @Setter
    @Column(nullable = false)
    private LocalDateTime created;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

}
