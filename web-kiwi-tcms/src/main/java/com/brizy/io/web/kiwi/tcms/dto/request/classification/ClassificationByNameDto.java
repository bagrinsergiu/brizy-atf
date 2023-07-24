package com.brizy.io.web.kiwi.tcms.dto.request.classification;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ClassificationByNameDto {

    @Builder.Default
    @JsonProperty("name")
    String name = "";

}
