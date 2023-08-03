package com.brizy.io.web.kiwi.tcms.dto.request.test_case;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder(toBuilder = true)
public class CreateTestCaseDto {

    @JsonProperty("is_automated")
    Boolean isAutomated;
    String script;
    String arguments;
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
    Long caseStatus;
    Long category;
    Long priority;
    Long product;
    Long author;
    @JsonProperty("default_tester")
    Long defaultTester;
    Long reviewer;
    @JsonProperty("create_date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    Date createDate;
    @Builder.Default
    Boolean notifyAuthor = false;
    @Builder.Default
    Boolean notifyManagerOfRuns = false;
    @Builder.Default
    Boolean notifyAssignees = false;
    @Builder.Default
    Boolean notifyDefaultTester = false;
    @Builder.Default
    Boolean notifyTesterOfRuns = false;
    @Builder.Default
    Boolean notifyWhenTestCaseIsUpdated = false;
    @Builder.Default
    Boolean notifyWhenTestCaseIsDeleted = false;

}
