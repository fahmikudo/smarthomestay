package com.fahmikudo.tritronik.smarthomestay.controller;

import com.fahmikudo.tritronik.smarthomestay.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    @PostMapping(value = "/checkin")
    public ResponseEntity<?> checkIn(@RequestBody Order order) {
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
