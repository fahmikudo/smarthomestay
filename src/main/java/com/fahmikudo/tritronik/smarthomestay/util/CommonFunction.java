package com.fahmikudo.tritronik.smarthomestay.util;

import org.springframework.http.HttpStatus;

public class CommonFunction {

    public static BaseResponse getError(ResponseStatus responseStatus, String message) {
        return new BaseResponse(responseStatus);
    }

}
