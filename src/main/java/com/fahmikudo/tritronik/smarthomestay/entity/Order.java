package com.fahmikudo.tritronik.smarthomestay.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order extends BaseEntity {

    private BigDecimal totalPrice;
    private Integer totalQty;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private String notes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_detail_id", referencedColumnName = "id")
    private OrderDetail orderDetail;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_payment_id", referencedColumnName = "id")
    private OrderPayment orderPayment;

    @OneToMany(mappedBy = "order")
    private Set<Users> users;

}
