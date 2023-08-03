package com.brizy.io.web.kiwi.tcms.dto.request.test_case;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class TestCaseByNameDto {

    @Builder.Default
    @JsonProperty("summary")
    String summary = "";

}
