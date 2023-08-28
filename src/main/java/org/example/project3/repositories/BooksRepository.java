package org.example.project3.repositories;

import org.example.project3.models.Book;
import org.example.project3.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book,Integer> {
    List<Book> findByNameStartingWith(String name);

}
