package com.alura.literalura.repository;

import com.alura.literalura.entity.book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<book, Long> {
    List<book> findByLanguage(String language);
}
