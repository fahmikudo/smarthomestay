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

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "order")
    private Set<OrderPayment> orderPayments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;

}
