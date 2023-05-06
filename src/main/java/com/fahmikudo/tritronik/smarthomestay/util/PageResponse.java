package com.fahmikudo.tritronik.smarthomestay.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long totalData;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer totalPage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer size;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer page;

}
