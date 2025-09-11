package org.geeksforgeeks.digitallibrary.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.geeksforgeeks.digitallibrary.entity.UserEntity;
import org.geeksforgeeks.digitallibrary.exception.DuplicateUser;
import org.geeksforgeeks.digitallibrary.exception.UserNotFoundException;
import org.geeksforgeeks.digitallibrary.models.UserDto;
import org.geeksforgeeks.digitallibrary.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    public UserDto createUser(UserDto user) {
        if (this.repository.getAllUsers().stream().anyMatch(e -> e.getFirstName().equals(user.getFirstName()) && e.getLastName().equals(user.getLastName())))
            throw new DuplicateUser();
        UserEntity entity = this.modelMapper.map(user, UserEntity.class);
        this.repository.createUser(entity);
        return user;
    }

    @Override
    public UserDto getUserById(int id) {
        UserEntity entity = this.repository.getById(id).orElseThrow(UserNotFoundException::new);
        return this.modelMapper.map(entity, UserDto.class);
    }

    @Override
    public UserDto updateUser(int id, UserDto user) {
        this.repository.getById(id).orElseThrow(UserNotFoundException::new);
        UserEntity entity = this.modelMapper.map(user, UserEntity.class);
        entity.setId(id);
        this.repository.updateUser(entity);
        return user;
    }

    @Override
    public String deleteUserById(int id) {
        this.repository.deleteUserById(id);
        return "User deleted with Id: " + id;
    }
}
