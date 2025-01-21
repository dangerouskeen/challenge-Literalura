package com.alura.literalura.entity;

import jakarta.persistence.*;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer birthYear;
    private Integer deathYear;

    // Getters, setters y toString
}
