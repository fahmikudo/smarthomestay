package com.fahmikudo.tritronik.smarthomestay.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResponse {

    private Integer statusCode;
    private String status;
    private String message;
    private ResultResponse result;
    @JsonIgnore
    private HttpStatus httpStatus;

    public BaseResponse(ResponseStatus responseStatus){
        setResponse(responseStatus);
    }

    public BaseResponse(ResponseStatus responseStatus, ResultResponse resultResponse) {
        setResponse(responseStatus);
        setResult(resultResponse);
    }

    public void setResponse(ResponseStatus responseStatus) {
        setStatusCode(responseStatus.getStatusCode());
        setStatus(responseStatus.getStatus());
        setMessage(responseStatus.getMessage());
        setHttpStatus(responseStatus.getHttpStatus());
    }

}
