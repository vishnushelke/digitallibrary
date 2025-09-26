package org.geeksforgeeks.digitallibrary.service.core;

import org.geeksforgeeks.digitallibrary.dto.CreateUserDto;
import org.geeksforgeeks.digitallibrary.dto.UpdateUserDto;

public interface IUserService {

    CreateUserDto createUser(CreateUserDto user);

    CreateUserDto getUserById(long id);

    CreateUserDto updateUser(long id, UpdateUserDto user);

    String deleteUserById(long id);

    String activateUserById(long id);
}
