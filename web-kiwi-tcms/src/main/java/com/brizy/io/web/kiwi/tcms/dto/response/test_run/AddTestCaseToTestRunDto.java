package com.brizy.io.web.kiwi.tcms.dto.response.test_run;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddTestCaseToTestRunDto {

    Long id;
    Long assignee;
    @JsonProperty("tested_by")
    Long tested_by;
    @JsonProperty("case_text_version")
    Long caseTextVersion;
    @JsonProperty("start_date")
    String startDate;
    @JsonProperty("stop_date")
    String stopDate;
    Long sortKey;
    Long run;
    @JsonProperty("case")
    Long testCase;
    Long status;
    Long build;

}
