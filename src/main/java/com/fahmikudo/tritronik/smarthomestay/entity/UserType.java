package com.fahmikudo.tritronik.smarthomestay.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UserType {

    EMPLOYEE, CUSTOMER;

    @JsonValue
    public String getUserType() {
        return this.name();
    }

}
