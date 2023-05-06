package com.fahmikudo.tritronik.smarthomestay.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "additional_facilities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalFacilities extends BaseEntity {

    @Column(name = "facility_name", length = 100)
    private String facilityName;
    @Column(name = "facility_type", length = 100)
    private String facilityType;
    @Column(name = "price")
    private BigDecimal price;

    @OneToMany(mappedBy = "additionalFacilities")
    private Set<OrderAdditional> orderAdditional;

}
