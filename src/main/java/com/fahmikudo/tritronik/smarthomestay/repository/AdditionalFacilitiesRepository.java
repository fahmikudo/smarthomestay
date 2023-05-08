package com.fahmikudo.tritronik.smarthomestay.repository;

import com.fahmikudo.tritronik.smarthomestay.entity.AdditionalFacilities;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalFacilitiesRepository extends BaseRepository<AdditionalFacilities> {

    Page<AdditionalFacilities> findAll(Pageable pageable);

    Page<AdditionalFacilities> findByFacilityNameContaining(Pageable pageable, String facilityName);

}
