package com.brizy.io.web.kiwi.tcms.dto.response.test_case;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CreateTestCaseDto {

    Long id;
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
    String setupDuration;
    @JsonProperty("testing_duration")
    String testingDuration;
    @JsonProperty("case_status")
    Long caseStatus;
    Long category;
    Long priority;
    Long author;
    @JsonProperty("default_tester")
    Long defaultTester;
    Long reviewer;
    @JsonProperty("create_date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    Date createDate;

}
