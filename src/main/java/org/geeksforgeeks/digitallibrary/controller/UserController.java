package org.geeksforgeeks.digitallibrary.controller;


import org.geeksforgeeks.digitallibrary.models.DigitalLibraryResponse;
import org.geeksforgeeks.digitallibrary.models.UserDto;
import org.geeksforgeeks.digitallibrary.service.IUserService;
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
    public ResponseEntity<DigitalLibraryResponse<UserDto>> createUser(@RequestBody UserDto user) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(SUCCESS_STATUS, this.service.createUser(user), null), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DigitalLibraryResponse<UserDto>> getUser(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(SUCCESS_STATUS, this.service.getUserById(id), null), HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<DigitalLibraryResponse<UserDto>> updateUser(@PathVariable int id, @RequestBody UserDto user) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(SUCCESS_STATUS, this.service.updateUser(id, user), null), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DigitalLibraryResponse<String>> deleteUser(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(SUCCESS_STATUS, this.service.deleteUserById(id), null), HttpStatus.OK);
    }
}
