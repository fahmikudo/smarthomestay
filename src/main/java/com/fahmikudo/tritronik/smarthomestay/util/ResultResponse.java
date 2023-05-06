package com.fahmikudo.tritronik.smarthomestay.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResultResponse {

    private Object data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer totalData;

    public ResultResponse(Object data) {
        this.data = data;
    }

}
