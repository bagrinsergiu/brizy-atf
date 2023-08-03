package com.brizy.io.web.kiwi.tcms.dto.request.test_run;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class AddTestCaseToTestRunDto {

    @JsonProperty("run_id")
    Long runId;
    @JsonProperty("case_id")
    Long caseId;

}
