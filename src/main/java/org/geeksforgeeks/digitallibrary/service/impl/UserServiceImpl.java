package org.geeksforgeeks.digitallibrary.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.geeksforgeeks.digitallibrary.entity.UserEntity;
import org.geeksforgeeks.digitallibrary.dto.CreateUserDto;
import org.geeksforgeeks.digitallibrary.dto.UpdateUserDto;
import org.geeksforgeeks.digitallibrary.exception.user.*;
import org.geeksforgeeks.digitallibrary.repository.impl.UserRepository;
import org.geeksforgeeks.digitallibrary.service.core.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository repository;
    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository repository, ObjectMapper objectMapper, ModelMapper modelMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
    }


    @Override
    public CreateUserDto createUser(CreateUserDto user) {
        List<UserEntity> users = this.repository.getAllUsers();
        if (users.stream().anyMatch(e -> e.getEmail().equals(user.getEmail()) && e.isActive()))
            throw new DuplicateUserException();
        if (users.stream().anyMatch(e -> !e.isActive() && e.getEmail().equals(user.getEmail())))
            throw new InActiveUserException();

        UserEntity entity = this.modelMapper.map(user, UserEntity.class);
        this.repository.createUser(entity);
        return user;
    }

    @Override
    public CreateUserDto getUserById(int id) {
        UserEntity entity = this.repository.getById(id).orElseThrow(UserNotFoundException::new);
        if (!entity.isActive()) throw new InActiveUserException();
        return this.modelMapper.map(entity, CreateUserDto.class);
    }

    @Override
    public CreateUserDto updateUser(int id, UpdateUserDto user) {
        UserEntity dbUser = this.repository.getById(id).orElseThrow(UserNotFoundException::new);
        if (!dbUser.isActive()) throw new InActiveUserException();
        UserEntity entity = this.modelMapper.map(user, UserEntity.class);
        entity.setId(id);
        entity.setEmail(dbUser.getEmail());
        this.repository.updateUser(entity);
        return this.modelMapper.map(entity, CreateUserDto.class);
    }

    @Override
    public String deleteUserById(int id) {
        UserEntity user = this.repository.getById(id).orElseThrow(UserNotFoundException::new);
        if (!user.isActive()) throw new UserAlreadyInActiveException();
        user.setActive(false);
        this.repository.updateUser(user);
        return "User deleted with Id: " + id;
    }

    @Override
    public String activateUserById(int id) {
        UserEntity user = this.repository.getById(id).orElseThrow(UserNotFoundException::new);
        if (user.isActive()) throw new UserAlreadyActiveException();
        user.setActive(true);
        this.repository.updateUser(user);
        return "User activated with Id: " + id;
    }
}
