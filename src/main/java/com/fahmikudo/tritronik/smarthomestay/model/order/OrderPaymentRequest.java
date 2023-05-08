package com.fahmikudo.tritronik.smarthomestay.model.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderPaymentRequest {

    private BigDecimal totalAmount;
    private String paymentType;
    private String paymentStatus;
    private String notes;

}
