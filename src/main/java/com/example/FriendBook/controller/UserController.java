package com.example.FriendBook.controller;

import com.example.FriendBook.dto.requestDTO.UserRequest;
import com.example.FriendBook.dto.responseDTO.UserResponse;
import com.example.FriendBook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity adduser(@RequestBody UserRequest newUser) {

        UserResponse createdUser = userService.adduser(newUser);
        return new ResponseEntity(createdUser, HttpStatus.CREATED);
    }
}
