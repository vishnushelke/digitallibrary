package org.geeksforgeeks.digitallibrary.service;

import org.geeksforgeeks.digitallibrary.models.UserDto;

public interface IUserService {

    UserDto createUser(UserDto user);

    UserDto getUserById(int id);

    UserDto updateUser(int id, UserDto user);

    String deleteUserById(int id);
}
