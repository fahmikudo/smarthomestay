package com.fahmikudo.tritronik.smarthomestay.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRegisterRequest {
    private String username;
    private String email;
    private String password;
    private String fullName;
    private String userType;

}
