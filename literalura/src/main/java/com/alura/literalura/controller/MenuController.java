package com.alura.literalura.controller;

import com.alura.literalura.service.AuthorService;
import com.alura.literalura.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class MenuController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Bienvenido al Catálogo de Libros y Autores");
        System.out.println("Proyecto: Catálogo de Libros utilizando API Gutendex y PostgreSQL");

        while (running) {
            System.out.println("\nMenú:");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar libros registrados");
            System.out.println("3. Listar autores registrados");
            System.out.println("4. Listar autores vivos en un año");
            System.out.println("5. Listar libros por idioma");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String title = scanner.nextLine();
                    bookService.searchAndSaveBookByTitle(title);
                    break;
                case 2:
                    bookService.listAllBooks();
                    break;
                case 3:
                    authorService.listAllAuthors();
                    break;
                case 4:
                    System.out.print("Ingrese el año para buscar autores vivos: ");
                    int year = scanner.nextInt();
                    authorService.listAuthorsAliveInYear(year);
                    break;
                case 5:
                    System.out.print("Ingrese el idioma (código ISO 639-1): ");
                    String language = scanner.nextLine();
                    bookService.listBooksByLanguage(language);
                    break;
                case 6:
                    running = false;
                    System.out.println("¡Gracias por usar la aplicación!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
        scanner.close();
    }
}
