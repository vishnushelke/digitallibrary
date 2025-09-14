package org.geeksforgeeks.digitallibrary.service;

import org.geeksforgeeks.digitallibrary.models.CreateUserDto;
import org.geeksforgeeks.digitallibrary.models.UpdateUserDto;

public interface IUserService {

    CreateUserDto createUser(CreateUserDto user);

    CreateUserDto getUserById(int id);

    CreateUserDto updateUser(int id, UpdateUserDto user);

    String deleteUserById(int id);

    String activateUserById(int id);
}
