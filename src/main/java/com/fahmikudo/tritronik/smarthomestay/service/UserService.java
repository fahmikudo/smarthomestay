package com.fahmikudo.tritronik.smarthomestay.service;

import com.fahmikudo.tritronik.smarthomestay.entity.Users;

public interface UserService {

    Users getUserForContext(String username) throws Exception;



}
