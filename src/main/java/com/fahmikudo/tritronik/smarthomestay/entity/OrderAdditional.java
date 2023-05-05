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
@Table(name = "order_additonals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderAdditional extends BaseEntity {

    private BigDecimal price;
    private Integer qty;
    private String notes;

    @OneToMany(mappedBy = "orderAdditional")
    private Set<OrderDetail> orderDetails;

}
