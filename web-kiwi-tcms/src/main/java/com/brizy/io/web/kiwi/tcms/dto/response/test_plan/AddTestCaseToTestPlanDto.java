package com.brizy.io.web.kiwi.tcms.dto.response.test_plan;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddTestCaseToTestPlanDto {

    Integer id;
    @JsonProperty("is_automated")
    Boolean isAutomated;
    String script;
    String arguments;
    @JsonProperty("extra_link")
    String extraLink;
    String summary;
    String requirement;
    String notes;
    String text;
    @JsonProperty("setup_duration")
    Double setupDuration;
    @JsonProperty("testing_duration")
    Double testingDuration;
    @JsonProperty("case_status")
    Integer caseStatus;
    Integer category;
    Integer priority;
    Integer author;
    @JsonProperty("default_tester")
    Integer defaultTester;
    Integer reviewer;
    @JsonProperty("create_date")
    String createDate;
    Integer sortkey;

}
