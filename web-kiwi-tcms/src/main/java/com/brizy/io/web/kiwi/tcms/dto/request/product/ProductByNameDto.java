package com.brizy.io.web.kiwi.tcms.dto.request.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ProductByNameDto {

    @Builder.Default
    @JsonProperty("name")
    String name = "";

}
