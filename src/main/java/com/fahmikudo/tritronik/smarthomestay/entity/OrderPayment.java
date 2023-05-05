package com.fahmikudo.tritronik.smarthomestay.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "order_payment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderPayment extends BaseEntity {

    private BigDecimal totalAmount;
    private String paymentType;
    private String paymentStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

}
