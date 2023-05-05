package com.fahmikudo.tritronik.smarthomestay.model;

import org.springframework.security.core.userdetails.UserDetails;

public interface LoginAbleUser extends UserDetails {


    public String getUsername();

    public String getPassword();

}
