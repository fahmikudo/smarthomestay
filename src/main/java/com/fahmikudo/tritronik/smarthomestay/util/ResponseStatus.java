package com.fahmikudo.tritronik.smarthomestay.util;

import org.springframework.http.HttpStatus;

public enum ResponseStatus {

    SUCCESS(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), "Success", HttpStatus.OK),
    INVALID_REQUEST(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), "Invalid Request.", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "Internal Server Error.", HttpStatus.INTERNAL_SERVER_ERROR),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase(), "User is not valid or username password is not match.", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED_CREDENTIALS(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase(), "Credentials is not valid.", HttpStatus.UNAUTHORIZED),
    DATA_NOT_FOUND(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), "Data not found.", HttpStatus.NOT_FOUND),
    ACCESS_DENIED(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase(), "Access Denied.", HttpStatus.FORBIDDEN);

    private Integer statusCode;
    private String status;
    private String message;
    private HttpStatus httpStatus;

    ResponseStatus(Integer statusCode, String status, String message, HttpStatus httpStatus) {
        this.setStatusCode(statusCode);
        this.setStatus(status);
        this.setMessage(message);
        this.setHttpStatus(httpStatus);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

}
