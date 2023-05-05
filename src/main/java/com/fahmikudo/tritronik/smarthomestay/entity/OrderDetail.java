package com.fahmikudo.tritronik.smarthomestay.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "order_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail extends BaseEntity {

    private BigDecimal price;
    private Integer qty;
    private String notes;

    @OneToMany(mappedBy = "orderDetail")
    private Set<Order> orders;
    @OneToMany(mappedBy = "orderDetail")
    private Set<Room> rooms;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_detail_id", referencedColumnName = "id")
    private OrderAdditional orderAdditional;

}
