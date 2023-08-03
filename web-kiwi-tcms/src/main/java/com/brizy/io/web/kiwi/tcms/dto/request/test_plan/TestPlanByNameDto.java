package com.brizy.io.web.kiwi.tcms.dto.request.test_plan;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class TestPlanByNameDto {

    @Builder.Default
    @JsonProperty("name")
    String name = "";

}
