package com.fahmikudo.tritronik.smarthomestay.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "order_additionals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderAdditional extends BaseEntity {
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_detail_id", referencedColumnName = "id")
    private OrderDetail orderDetail;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "additional_facilities_id", referencedColumnName = "id")
    private AdditionalFacilities additionalFacilities;

}
