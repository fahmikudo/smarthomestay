package com.fahmikudo.tritronik.smarthomestay.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

    @OneToMany(mappedBy = "orderPayment")
    private Set<Order> orders;

}
