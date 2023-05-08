package com.fahmikudo.tritronik.smarthomestay.util;

public class CommonFunction {

    public static BaseResponse getError(ResponseStatus responseStatus, String message) {
        return new BaseResponse(responseStatus);
    }

}
