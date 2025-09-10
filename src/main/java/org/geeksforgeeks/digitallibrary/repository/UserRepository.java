package org.geeksforgeeks.digitallibrary.repository;

import org.geeksforgeeks.digitallibrary.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    private final UserJPARepository jpaRepository;

    public UserRepository(UserJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public UserEntity createUser(UserEntity user) {
        return this.jpaRepository.save(user);
    }

    public Optional<UserEntity> getById(int id) {
        return this.jpaRepository.findById(id);
    }

    public UserEntity updateUser(UserEntity user) {
        return this.jpaRepository.save(user);
    }

    public void deleteUserById(int id) {
        this.jpaRepository.deleteById(id);
    }
}
