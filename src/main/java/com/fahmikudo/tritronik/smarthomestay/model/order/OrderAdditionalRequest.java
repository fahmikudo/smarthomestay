package com.fahmikudo.tritronik.smarthomestay.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderAdditionalRequest {

    private Long additionalFacilityId;
    private Integer qty;

    private String notes;

}
