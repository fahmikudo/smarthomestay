package com.fahmikudo.tritronik.smarthomestay.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "additional_facilities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalFacilities extends BaseEntity {

    private String facilityName;
    private String facilityType;
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_additional_id", referencedColumnName = "id")
    private OrderAdditional orderAdditional;

}
