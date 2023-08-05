package com.brizy.io.web.kiwi.tcms.dto.request.test_plan;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class AddTestCaseToTestPlanDto {

    @JsonProperty("plan_id")
    Long planId;
    @JsonProperty("case_id")
    Long caseId;

}
