package org.geeksforgeeks.digitallibrary.service.core;

import org.geeksforgeeks.digitallibrary.dto.CreateUserDto;
import org.geeksforgeeks.digitallibrary.dto.UpdateUserDto;

public interface IUserService {

    CreateUserDto createUser(CreateUserDto user);

    CreateUserDto getUserById(int id);

    CreateUserDto updateUser(int id, UpdateUserDto user);

    String deleteUserById(int id);

    String activateUserById(int id);
}
