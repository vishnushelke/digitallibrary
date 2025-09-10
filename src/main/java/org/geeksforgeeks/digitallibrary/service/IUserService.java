package org.geeksforgeeks.digitallibrary.service;

import org.geeksforgeeks.digitallibrary.entity.UserEntity;

public interface IUserService {

    UserEntity createUser(UserEntity user);

    UserEntity getUserById(int id);

    UserEntity updateUser(UserEntity user);

    void deleteUserById(int id);
}
