package com.fahmikudo.tritronik.smarthomestay.service;

import com.fahmikudo.tritronik.smarthomestay.entity.AdditionalFacilities;
import com.fahmikudo.tritronik.smarthomestay.model.additionalfacility.AdditionalFacilityResponse;
import com.fahmikudo.tritronik.smarthomestay.model.additionalfacility.ListAdditionalFacilityResponse;
import com.fahmikudo.tritronik.smarthomestay.repository.AdditionalFacilitiesRepository;
import com.fahmikudo.tritronik.smarthomestay.util.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdditionalFacilityService {

    private final AdditionalFacilitiesRepository additionalFacilitiesRepository;

    @Transactional(readOnly = true)
    public ListAdditionalFacilityResponse getAllAdditionalFacilities(int page, int size, String keyword) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("createdAt").descending());
        Page<AdditionalFacilities> additionalFacilities;
        if (keyword != null) {
            additionalFacilities = additionalFacilitiesRepository.findByFacilityNameContaining(pageable, keyword);
        } else {
            additionalFacilities = additionalFacilitiesRepository.findAll(pageable);
        }

        PageResponse pageResponse = new PageResponse(additionalFacilities.getTotalElements(),
                additionalFacilities.getTotalPages(),
                size,
                page);

        if (additionalFacilities.isEmpty()) {
            return new ListAdditionalFacilityResponse(pageResponse, new ArrayList<>());
        }

        List<AdditionalFacilityResponse> additionalFacilityResponses = new ArrayList<>();
        for (AdditionalFacilities additionalFacility : additionalFacilities) {
            AdditionalFacilityResponse additionalFacilityResponse = AdditionalFacilityResponse.builder()
                    .id(additionalFacility.getId())
                    .facilityName(additionalFacility.getFacilityName())
                    .facilityType(additionalFacility.getFacilityType())
                    .price(additionalFacility.getPrice())
                    .build();
            additionalFacilityResponses.add(additionalFacilityResponse);
        }

        return ListAdditionalFacilityResponse.builder()
                .page(pageResponse)
                .additionalFacilities(additionalFacilityResponses)
                .build();
    }

}
