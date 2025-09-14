package org.geeksforgeeks.digitallibrary.repository.jpa;

import org.geeksforgeeks.digitallibrary.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {
}
