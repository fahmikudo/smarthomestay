package com.fahmikudo.tritronik.smarthomestay.model.additionalfacility;

import com.fahmikudo.tritronik.smarthomestay.util.PageResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ListAdditionalFacilityResponse {

    private PageResponse page;
    private List<AdditionalFacilityResponse> additionalFacilities;



}
