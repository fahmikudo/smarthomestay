package com.fahmikudo.tritronik.smarthomestay.controller;

import com.fahmikudo.tritronik.smarthomestay.model.additionalfacility.ListAdditionalFacilityResponse;
import com.fahmikudo.tritronik.smarthomestay.service.AdditionalFacilityService;
import com.fahmikudo.tritronik.smarthomestay.util.BaseResponse;
import com.fahmikudo.tritronik.smarthomestay.util.ResponseStatus;
import com.fahmikudo.tritronik.smarthomestay.util.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("additional-facility")
@RequiredArgsConstructor
public class AdditionalFacilityController {

    private BaseResponse baseResponse;
    private final AdditionalFacilityService additionalFacilityService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getAllAdditionalFacilities(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "keyword", required = false) String keyword) {
        try {
            ListAdditionalFacilityResponse listAdditionalFacilityResponse =
                    additionalFacilityService.getAllAdditionalFacilities(page, size, keyword);

            ResultResponse resultResponse = ResultResponse.builder()
                    .page(listAdditionalFacilityResponse.getPage())
                    .data(listAdditionalFacilityResponse.getAdditionalFacilities())
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
