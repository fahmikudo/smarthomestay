package com.fahmikudo.tritronik.smarthomestay.service;

import com.fahmikudo.tritronik.smarthomestay.entity.Users;
import com.fahmikudo.tritronik.smarthomestay.repository.UserRepository;
import com.fahmikudo.tritronik.smarthomestay.security.PBKDF2Encoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PBKDF2Encoder encoder;

    private final UserRepository userRepository;

    public void registerUser(Users users) {
        Users newUser = new Users();
        newUser.setFullname(users.getFullname());
        newUser.setUsername(users.getUsername());
        newUser.setUserType(users.getUserType());
        newUser.setEmail(users.getEmail());
        newUser.setPassword(encoder.encode(users.getPassword()));

        userRepository.save(newUser);
    }



}
