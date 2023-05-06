package com.fahmikudo.tritronik.smarthomestay.exception;

import com.fahmikudo.tritronik.smarthomestay.util.BaseResponse;
import com.fahmikudo.tritronik.smarthomestay.util.ResponseStatus;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Log4j2
public class CustomExceptionHandler {

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public ResponseEntity<BaseResponse> defaultErrorHandler(HttpServletRequest req, Exception e) {
        underlyingCachingRequest(req, e);
        BaseResponse baseResponse = new BaseResponse(ResponseStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @ExceptionHandler(value = InvalidRequestException.class)
    public ResponseEntity<BaseResponse> invalidParameter(HttpServletRequest req, Exception e) {
        underlyingCachingRequest(req, e);
        BaseResponse baseResponse = new BaseResponse(ResponseStatus.INVALID_REQUEST);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @ExceptionHandler(value = {UnauthorizedException.class, AuthenticationException.class})
    public ResponseEntity<BaseResponse> unauthorized(HttpServletRequest req, Exception e){
        underlyingCachingRequest(req, e);
        BaseResponse baseResponse = new BaseResponse(ResponseStatus.UNAUTHORIZED);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @ExceptionHandler(value = DataNotFoundException.class)
    public ResponseEntity<BaseResponse> dataNotFound(HttpServletRequest req, Exception e){
        underlyingCachingRequest(req, e);
        BaseResponse baseResponse = new BaseResponse(ResponseStatus.DATA_NOT_FOUND);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    private void underlyingCachingRequest(HttpServletRequest req, Exception e) {
        Throwable rootEx = ExceptionUtils.getRootCause(e);
        String message = "ERROR SERVICE | Message: " + rootEx.getMessage() + " | Request URL : " + req.getRequestURI();
        log.error(message, e);
    }

}
