package com.example.FriendBook.service;

import com.example.FriendBook.dto.requestDTO.UserRequest;
import com.example.FriendBook.dto.responseDTO.PostResponse;
import com.example.FriendBook.dto.responseDTO.UserResponse;
import com.example.FriendBook.exception.DuplicateKeyException;
import com.example.FriendBook.model.User;
import com.example.FriendBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserResponse adduser(UserRequest newUser) {

        // convert request DTO ---> model
        User user = new User();
        user.setUserName(newUser.getUserName());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        user.setPosts(new ArrayList<>());

        // Check if username and email are unique (you may want to add more checks)
        if (userRepository.findByUserName(user.getUserName()).isPresent() ||
                userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new DuplicateKeyException("Username or email already exists");
        }

        User saveUser = userRepository.save(user);

        //saved model to response dto, i.e convert model to dto
        UserResponse userResponse = new UserResponse();
        userResponse.setUserName(saveUser.getUserName());
        userResponse.setEmail(saveUser.getEmail());

        return userResponse;

    }
}
