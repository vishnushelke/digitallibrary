package org.geeksforgeeks.digitallibrary.repository.impl;

import org.geeksforgeeks.digitallibrary.entity.BookEntity;
import org.geeksforgeeks.digitallibrary.repository.jpa.BookJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    private BookJpaRepository repository;

    public BookRepository(BookJpaRepository repository) {
        this.repository = repository;
    }

    public BookEntity addBook(BookEntity book) {
        return this.repository.save(book);
    }

    public Optional<BookEntity> getBookById(long id) {
        return this.repository.findById(id);
    }

    public BookEntity updateBook(BookEntity book) {
        return this.repository.save(book);
    }

    public String removeBookById(long id) {
        this.repository.deleteById(id);
        return "Book is removed with id: " + id;
    }

    public List<BookEntity> getAllBooks() {
        return this.repository.findAll();
    }
}
