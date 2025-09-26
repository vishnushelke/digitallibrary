package org.geeksforgeeks.digitallibrary.repository.jpa;

import org.geeksforgeeks.digitallibrary.entity.BookEntity;
import org.geeksforgeeks.digitallibrary.entity.BookIssueEntity;
import org.geeksforgeeks.digitallibrary.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookIssueJpaRepository extends JpaRepository<BookIssueEntity, Long> {

    public List<BookIssueEntity> findByUser(UserEntity entity);

    Optional<BookIssueEntity> findByUserAndBook(UserEntity entity, BookEntity book);
}
