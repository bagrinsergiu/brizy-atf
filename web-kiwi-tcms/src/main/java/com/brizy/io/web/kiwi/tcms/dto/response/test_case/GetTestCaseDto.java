package com.brizy.io.web.kiwi.tcms.dto.response.test_case;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetTestCaseDto {

    Long id;
    @JsonProperty("create_date")
    String createdDate;
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
    @JsonProperty("case_status")
    Long caseStatus;
    @JsonProperty("case_status__name")
    String caseStatusName;
    Long category;
    @JsonProperty("category__name")
    String categoryName;
    Long priority;
    @JsonProperty("priority__value")
    String priorityValue;
    Long author;
    @JsonProperty("author__username")
    String authorUsername;
    @JsonProperty("default_tester")
    Long defaultTester;
    @JsonProperty("default_tester__username")
    String defaultTesterUsername;
    Long reviewer;
    @JsonProperty("reviewer__username")
    String reviewerUsername;
    @JsonProperty("setup_duration")
    Double setupDuration;
    @JsonProperty("testing_duration")
    Double testingDuration;
    @JsonProperty("expected_duration")
    Double expectedDuration;

}
