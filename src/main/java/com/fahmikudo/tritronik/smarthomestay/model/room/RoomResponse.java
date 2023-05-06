package com.fahmikudo.tritronik.smarthomestay.model.room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RoomResponse {

    private Long id;
    private String roomName;
    private String roomType;
    private BigDecimal price;
    private Double latitude;
    private Double longitude;

}
