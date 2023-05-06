package com.fahmikudo.tritronik.smarthomestay.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room extends BaseEntity {

    @Column(name = "room_name", length = 100)
    private String roomName;
    @Column(name = "room_type", length = 100)
    private String roomType;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @OneToMany(mappedBy = "room")
    private Set<OrderDetail> orderDetails;


}
