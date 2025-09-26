package org.geeksforgeeks.digitallibrary.repository.impl;

import org.geeksforgeeks.digitallibrary.entity.BookEntity;
import org.geeksforgeeks.digitallibrary.entity.BookIssueEntity;
import org.geeksforgeeks.digitallibrary.entity.UserEntity;
import org.geeksforgeeks.digitallibrary.repository.jpa.BookIssueJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookIssueRepository {

    private BookIssueJpaRepository repository;

    public BookIssueRepository(BookIssueJpaRepository repository) {
        this.repository = repository;
    }

    public BookIssueEntity issueBook(BookIssueEntity entity) {
        return this.repository.save(entity);
    }

    public Optional<BookIssueEntity> getIssuedBookById(long id) {
        return this.repository.findById(id);
    }

    public BookIssueEntity updateBookIssued(BookIssueEntity entity) {
        return this.repository.save(entity);
    }

    public void deleteBookIssuedById(long id) {
        this.repository.deleteById(id);
    }

    public List<BookIssueEntity> getBooksForUser(UserEntity entity) {
//        return this.repository.findAll().stream().filter(e -> e.getUser().getId() == id).collect(Collectors.toList());
        return this.repository.findByUser(entity);
    }

    public Optional<BookIssueEntity> getIssuedBookByUserAndBook(UserEntity user, BookEntity book){
        return this.repository.findByUserAndBook(user, book);
    }
}
