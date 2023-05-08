package com.fahmikudo.tritronik.smarthomestay.controller;

import com.fahmikudo.tritronik.smarthomestay.entity.Order;
import com.fahmikudo.tritronik.smarthomestay.entity.User;
import com.fahmikudo.tritronik.smarthomestay.model.order.CheckInRequest;
import com.fahmikudo.tritronik.smarthomestay.model.order.OrderResponse;
import com.fahmikudo.tritronik.smarthomestay.service.OrderService;
import com.fahmikudo.tritronik.smarthomestay.service.UserService;
import com.fahmikudo.tritronik.smarthomestay.util.BaseResponse;
import com.fahmikudo.tritronik.smarthomestay.util.ResponseStatus;
import com.fahmikudo.tritronik.smarthomestay.util.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private BaseResponse baseResponse;
    private final UserService userService;
    private final OrderService orderService;

    private User getUserActiveFromContext() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUserForContext(username);
        return user;
    }

    @PostMapping(value = "/check-in", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> checkIn(@RequestBody CheckInRequest checkInRequest) {
        try {
            User user = getUserActiveFromContext();

            OrderResponse orderResponse = orderService.checkIn(checkInRequest, user);

            ResultResponse resultResponse = ResultResponse.builder()
                    .data(orderResponse)
                    .build();

            baseResponse = new BaseResponse(ResponseStatus.SUCCESS, resultResponse);
            return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse = new BaseResponse(ResponseStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
        }
    }

}
