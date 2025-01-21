package com.alura.literalura.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @JsonAlias("download_count")
    private int downloads;

    @JsonAlias("languages")
    private String language;

    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;

    public void setTitle(String title) {
    }

    public void setLanguage(String languages) {
    }

    public void setDownloads(int downloadCount) {
    }

    // Getters, setters y toString
}
