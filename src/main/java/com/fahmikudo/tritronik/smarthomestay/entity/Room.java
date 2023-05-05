package com.fahmikudo.tritronik.smarthomestay.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "room")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room extends BaseEntity {

    private String roomName;
    private String roomType;
    private BigDecimal price;
    private Double latitude;
    private Double longitude;
    @OneToMany(mappedBy = "room")
    private Set<OrderDetail> orderDetails;


}
