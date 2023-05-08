package com.fahmikudo.tritronik.smarthomestay.model.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderRequest {

    private Long roomId;
    private Integer qty;
    private String notes;
    private List<OrderAdditionalRequest> additionalRequests;

}
