package com.fahmikudo.tritronik.smarthomestay.controller;

import com.fahmikudo.tritronik.smarthomestay.entity.Users;
import com.fahmikudo.tritronik.smarthomestay.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerUser(@RequestBody Users users) {
        userService.registerUser(users);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> getUser() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
