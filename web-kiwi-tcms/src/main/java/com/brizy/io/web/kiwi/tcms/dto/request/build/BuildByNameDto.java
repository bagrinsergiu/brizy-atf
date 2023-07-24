package com.brizy.io.web.kiwi.tcms.dto.request.build;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class BuildByNameDto {

    @Builder.Default
    @JsonProperty("name")
    String name = "";

}
