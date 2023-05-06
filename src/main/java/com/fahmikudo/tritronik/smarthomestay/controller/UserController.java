package com.fahmikudo.tritronik.smarthomestay.controller;

import com.fahmikudo.tritronik.smarthomestay.model.AuthRequest;
import com.fahmikudo.tritronik.smarthomestay.model.AuthResponse;
import com.fahmikudo.tritronik.smarthomestay.model.user.UserRegisterRequest;
import com.fahmikudo.tritronik.smarthomestay.model.user.UserRegisterResponse;
import com.fahmikudo.tritronik.smarthomestay.service.UserService;
import com.fahmikudo.tritronik.smarthomestay.util.BaseResponse;
import com.fahmikudo.tritronik.smarthomestay.util.ResponseStatus;
import com.fahmikudo.tritronik.smarthomestay.util.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private BaseResponse baseResponse;

    private final UserService userService;
    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> registerUser(@RequestBody UserRegisterRequest userRegisterRequest) {
        try {
            UserRegisterResponse userRegisterResponse = userService.registerUser(userRegisterRequest);
            ResultResponse resultResponse = ResultResponse.builder()
                    .data(userRegisterResponse)
                    .build();
            baseResponse = new BaseResponse(ResponseStatus.SUCCESS, resultResponse);
            return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse = new BaseResponse(ResponseStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
        }
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> userLogin(@RequestBody AuthRequest authRequest) {
        try {
            AuthResponse authResponse = userService.userLogin(authRequest);
            ResultResponse resultResponse = ResultResponse.builder()
                    .data(authResponse)
                    .build();
            baseResponse = new BaseResponse(ResponseStatus.SUCCESS, resultResponse);
            return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse = new BaseResponse(ResponseStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
        }
    }

}
