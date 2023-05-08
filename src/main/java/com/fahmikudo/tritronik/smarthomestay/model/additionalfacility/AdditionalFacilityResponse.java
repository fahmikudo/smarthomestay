package com.fahmikudo.tritronik.smarthomestay.model.additionalfacility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AdditionalFacilityResponse {

    private Long id;
    private String facilityName;
    private String facilityType;
    private BigDecimal price;

}
