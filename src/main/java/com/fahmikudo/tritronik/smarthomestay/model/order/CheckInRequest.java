package com.fahmikudo.tritronik.smarthomestay.model.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckInRequest {

    private List<OrderRequest> itemOrders;
    private String notes;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date checkInTime;

    private OrderPaymentRequest orderPayment;



}
