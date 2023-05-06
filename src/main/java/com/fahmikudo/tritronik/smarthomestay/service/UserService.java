package com.fahmikudo.tritronik.smarthomestay.service;

import com.fahmikudo.tritronik.smarthomestay.entity.User;
import com.fahmikudo.tritronik.smarthomestay.entity.UserType;
import com.fahmikudo.tritronik.smarthomestay.exception.DataNotFoundException;
import com.fahmikudo.tritronik.smarthomestay.exception.InvalidRequestException;
import com.fahmikudo.tritronik.smarthomestay.exception.UnauthorizedException;
import com.fahmikudo.tritronik.smarthomestay.model.AuthRequest;
import com.fahmikudo.tritronik.smarthomestay.model.AuthResponse;
import com.fahmikudo.tritronik.smarthomestay.model.LoginAbleUser;
import com.fahmikudo.tritronik.smarthomestay.model.user.UserRegisterRequest;
import com.fahmikudo.tritronik.smarthomestay.model.user.UserRegisterResponse;
import com.fahmikudo.tritronik.smarthomestay.repository.UserRepository;
import com.fahmikudo.tritronik.smarthomestay.security.JwtUtil;
import com.fahmikudo.tritronik.smarthomestay.security.PBKDF2Encoder;
import com.fahmikudo.tritronik.smarthomestay.util.ResponseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserService {

    private final PBKDF2Encoder encoder;

    private final JwtUtil jwtUtil;

    private final UserRepository userRepository;

    public User getUserForContext(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent())
            throw new DataNotFoundException(ResponseStatus.DATA_NOT_FOUND.getMessage(), "username with " + username + " not found.");
        return user.get();
    }

    @Transactional
    public UserRegisterResponse registerUser(UserRegisterRequest userRegisterRequest) {

        Optional<User> user = userRepository.findByUsername(userRegisterRequest.getUsername());
        if (user.isPresent())
            throw new InvalidRequestException(ResponseStatus.INVALID_REQUEST.getMessage(), "username is already exists.");

        User newUser = new User();
        newUser.setFullName(userRegisterRequest.getFullName());
        newUser.setUsername(userRegisterRequest.getUsername());
        newUser.setUserType(UserType.valueOf(userRegisterRequest.getUserType()));
        newUser.setEmail(userRegisterRequest.getEmail());
        newUser.setPassword(encoder.encode(userRegisterRequest.getPassword()));

        userRepository.save(newUser);

        return UserRegisterResponse.builder()
                .userId(newUser.getId())
                .username(newUser.getUsername())
                .build();

    }

    public AuthResponse userLogin(AuthRequest authRequest) {
        LoginAbleUser userLogin = null;
        Optional<User> user = userRepository.findByUsername(authRequest.getUsername());
        if (!user.isPresent()) {
            log.info(">>>>> user not present <<<<<");
            throw new InvalidRequestException(ResponseStatus.DATA_NOT_FOUND.getMessage(), "username with " + authRequest.getUsername() + " not found");
        }
        userLogin = user.get();
        if (userLogin == null) {
            log.info(">>>>> user login not present <<<<<");
            throw new UnauthorizedException(ResponseStatus.UNAUTHORIZED.getMessage());
        }
        CharSequence password = userLogin.getPassword();
        String passwordRequest = encoder.encode(authRequest.getPassword());
        if (!password.equals(passwordRequest)) {
            log.info(">>>>> password not equal <<<<<");
            throw new UnauthorizedException(ResponseStatus.UNAUTHORIZED.getMessage());
        }

        return AuthResponse.builder()
                .token(jwtUtil.generateToken(userLogin))
                .username(userLogin.getUsername())
                .email(user.get().getEmail())
                .fullName(user.get().getFullName())
                .build();
    }



}
