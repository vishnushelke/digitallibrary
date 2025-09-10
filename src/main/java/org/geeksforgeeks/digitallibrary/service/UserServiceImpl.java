package org.geeksforgeeks.digitallibrary.service;

import org.geeksforgeeks.digitallibrary.entity.UserEntity;
import org.geeksforgeeks.digitallibrary.exception.GlobalException;
import org.geeksforgeeks.digitallibrary.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserEntity createUser(UserEntity user) {
        return this.repository.createUser(user);
    }

    @Override
    public UserEntity getUserById(int id) {
        return this.repository.getById(id).orElseThrow(() -> new GlobalException("User not found by Id: " + id));
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        return this.repository.updateUser(user);
    }

    @Override
    public void deleteUserById(int id) {
        this.repository.deleteUserById(id);
    }
}
