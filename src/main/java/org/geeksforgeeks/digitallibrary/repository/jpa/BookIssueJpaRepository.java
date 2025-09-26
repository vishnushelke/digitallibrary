package org.geeksforgeeks.digitallibrary.repository.jpa;

import org.geeksforgeeks.digitallibrary.dao.BookIssueCount;
import org.geeksforgeeks.digitallibrary.entity.BookEntity;
import org.geeksforgeeks.digitallibrary.entity.BookIssueEntity;
import org.geeksforgeeks.digitallibrary.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookIssueJpaRepository extends JpaRepository<BookIssueEntity, Long> {

    public List<BookIssueEntity> findByUser(UserEntity entity);

    Optional<BookIssueEntity> findByUserAndBook(UserEntity entity, BookEntity book);

    @Query("""
            SELECT book, count(1)
            FROM BookIssueEntity
            GROUP BY book 
            ORDER BY count(1) DESC
            """)
    List<BookIssueCount> findMostIssuedBooks(Pageable pageable);
}
