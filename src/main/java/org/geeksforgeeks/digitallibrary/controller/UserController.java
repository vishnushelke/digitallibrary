package org.geeksforgeeks.digitallibrary.controller;


import org.geeksforgeeks.digitallibrary.models.DigitalLibraryResponse;
import org.geeksforgeeks.digitallibrary.dto.CreateUserDto;
import org.geeksforgeeks.digitallibrary.dto.UpdateUserDto;
import org.geeksforgeeks.digitallibrary.service.core.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.geeksforgeeks.digitallibrary.utils.Constants.SUCCESS_STATUS;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<DigitalLibraryResponse<CreateUserDto>> createUser(@RequestBody CreateUserDto user) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(SUCCESS_STATUS, this.service.createUser(user), null), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DigitalLibraryResponse<CreateUserDto>> getUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(SUCCESS_STATUS, this.service.getUserById(id), null), HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<DigitalLibraryResponse<CreateUserDto>> updateUser(@PathVariable Long id, @RequestBody UpdateUserDto user) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(SUCCESS_STATUS, this.service.updateUser(id, user), null), HttpStatus.OK);
    }

    @PatchMapping("/activate/{id}")
    public ResponseEntity<DigitalLibraryResponse<String>> activateUser(@PathVariable Long id) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(SUCCESS_STATUS, this.service.activateUserById(id), null), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DigitalLibraryResponse<String>> deleteUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(SUCCESS_STATUS, this.service.deleteUserById(id), null), HttpStatus.OK);
    }
}
