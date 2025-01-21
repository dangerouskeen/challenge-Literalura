package com.alura.literalura.service;

import com.alura.literalura.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void listAllAuthors() {
        authorRepository.findAll().forEach(System.out::println);
    }

    public void listAuthorsAliveInYear(int year) {
        authorRepository.findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(year, year)
                .forEach(System.out::println);
    }
}
