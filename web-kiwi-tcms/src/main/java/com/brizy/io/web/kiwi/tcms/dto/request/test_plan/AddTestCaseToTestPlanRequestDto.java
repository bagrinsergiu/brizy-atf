package com.brizy.io.web.kiwi.tcms.dto.request.test_plan;

import com.brizy.io.web.kiwi.tcms.dto.JsonRpcDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder(toBuilder = true)
public class AddTestCaseToTestPlanRequestDto extends JsonRpcDto {

    @Builder.Default
    @JsonProperty("method")
    String method = "";

    @Builder.Default
    @JsonProperty("params")
    AddTestCaseToTestPlanDto params = null;

}
