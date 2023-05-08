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
public class CalculatePaymentResponse {

    private BigDecimal totalAmount;
    private String paymentStatus;
    private String paymentType;

}
