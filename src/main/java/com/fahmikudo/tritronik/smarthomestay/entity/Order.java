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

    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @Column(name = "total_qty")
    private Integer totalQty;
    @Column(name = "check_in_time")
    private LocalDateTime checkInTime;
    @Column(name = "check_out_time")
    private LocalDateTime checkOutTime;
    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "order")
    private Set<OrderPayment> orderPayments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
