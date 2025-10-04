package org.geeksforgeeks.digitallibrary.service.core;

import org.geeksforgeeks.digitallibrary.dto.CreateUserDto;
import org.geeksforgeeks.digitallibrary.dto.UpdateUserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    CreateUserDto createUser(CreateUserDto user);

    CreateUserDto getUserById(long id);

    CreateUserDto updateUser(long id, UpdateUserDto user);

    Boolean updatePassword(long id, String password);

    String deleteUserById(long id);

    String activateUserById(long id);
}
