package org.geeksforgeeks.digitallibrary.repository.impl;

import org.geeksforgeeks.digitallibrary.entity.UserEntity;
import org.geeksforgeeks.digitallibrary.repository.jpa.UserJPARepository;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    public Optional<UserEntity> getById(long id) {
        return this.jpaRepository.findById(id);
    }

    public UserEntity updateUser(UserEntity user) {
        return this.jpaRepository.save(user);
    }

    public void deleteUserById(long id) {
        this.jpaRepository.deleteById(id);
    }

    public List<UserEntity> getAllUsers() {
        return this.jpaRepository.findAll();
    }
}
