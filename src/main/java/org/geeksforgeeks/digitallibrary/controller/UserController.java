package org.geeksforgeeks.digitallibrary.controller;


import org.geeksforgeeks.digitallibrary.entity.UserEntity;
import org.geeksforgeeks.digitallibrary.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }


    @GetMapping("/health")
    public ResponseEntity<?> healthCheck() {
        return new ResponseEntity<>("I am Alive!!", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        return new ResponseEntity<>(this.service.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(this.service.getUserById(id), HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user) {
        return new ResponseEntity<>(this.service.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Integer id) {
        this.service.deleteUserById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
