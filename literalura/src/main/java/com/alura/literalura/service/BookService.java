package com.alura.literalura.service;

import com.alura.literalura.entity.book;
import com.alura.literalura.repository.BookRepository;
import com.alura.literalura.client.GutendexClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GutendexClient gutendexClient;

    public void searchAndSaveBookByTitle(String title) {
        book book = gutendexClient.fetchBookByTitle(title);
        if (book != null) {
            bookRepository.save(book);
            System.out.println("Libro guardado exitosamente: " + book);
        } else {
            System.out.println("No se encontró el libro con título: " + title);
        }
    }

    public void listAllBooks() {
        bookRepository.findAll().forEach(System.out::println);
    }

    public void listBooksByLanguage(String language) {
        bookRepository.findByLanguage(language).forEach(System.out::println);
    }
}
