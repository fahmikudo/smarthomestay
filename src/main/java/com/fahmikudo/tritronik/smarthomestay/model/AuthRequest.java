package com.fahmikudo.tritronik.smarthomestay.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthRequest {

    private String username;
    private String password;

}
