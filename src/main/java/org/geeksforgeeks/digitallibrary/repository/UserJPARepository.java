package org.geeksforgeeks.digitallibrary.repository;

import org.geeksforgeeks.digitallibrary.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<UserEntity, Integer> {
}
