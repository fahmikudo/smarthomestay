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

    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @OneToMany(mappedBy = "orderDetail")
    private Set<OrderAdditional> orderAdditionals;

}
