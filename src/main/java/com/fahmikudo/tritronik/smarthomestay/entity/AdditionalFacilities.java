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

    private String facilityName;
    private String facilityType;
    private BigDecimal price;

    @OneToMany(mappedBy = "additionalFacilities")
    private Set<OrderAdditional> orderAdditional;

}
