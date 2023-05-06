package com.fahmikudo.tritronik.smarthomestay.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthResponse {

    private String token;
    private String username;
    private String email;
    private String fullName;

}
