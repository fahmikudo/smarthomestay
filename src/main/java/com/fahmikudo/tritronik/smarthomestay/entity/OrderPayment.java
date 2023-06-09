package com.fahmikudo.tritronik.smarthomestay.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "order_payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderPayment extends BaseEntity {

    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @Column(name = "payment_type", length = 10)
    private String paymentType;
    @Column(name = "payment_status", length = 10)
    private String paymentStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

}
