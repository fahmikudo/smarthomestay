package com.fahmikudo.tritronik.smarthomestay.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRegisterResponse {

    private Long userId;
    private String username;

}
