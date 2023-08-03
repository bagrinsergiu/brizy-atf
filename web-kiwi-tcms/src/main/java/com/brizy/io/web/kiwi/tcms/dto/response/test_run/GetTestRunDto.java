package com.brizy.io.web.kiwi.tcms.dto.response.test_run;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class GetTestRunDto {

    Long id;
    @JsonProperty("plan__product_version")
    Long planProductVersion;
    @JsonProperty("plan__product_version__value")
    String planProductVersionValue;
    @JsonProperty("start_date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    Date startDate;
    @JsonProperty("stop_date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    Date stopDate;
    @JsonProperty("planned_start")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    Date plannedStart;
    @JsonProperty("planned_stop")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    Date plannedStop;
    String summary;
    String notes;
    Long plan;
    @JsonProperty("plan__product")
    Long planProduct;
    @JsonProperty("plan__name")
    String planName;
    Long build;
    @JsonProperty("build__name")
    String buildName;
    Long manager;
    @JsonProperty("manager__username")
    String managerUsername;
    @JsonProperty("default_tester")
    Long defaultTester;
    @JsonProperty("default_tester__username")
    String defaultTesterUsername;

}
