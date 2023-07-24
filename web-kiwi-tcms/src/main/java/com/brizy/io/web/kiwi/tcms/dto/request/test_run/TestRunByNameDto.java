package com.brizy.io.web.kiwi.tcms.dto.request.test_run;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class TestRunByNameDto {

    @Builder.Default
    @JsonProperty("name")
    String name = "";

}
