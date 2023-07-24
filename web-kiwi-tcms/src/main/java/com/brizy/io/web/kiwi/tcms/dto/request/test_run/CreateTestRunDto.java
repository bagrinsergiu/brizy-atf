package com.brizy.io.web.kiwi.tcms.dto.request.test_run;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder(toBuilder = true)
public class CreateTestRunDto {

    String summary;
    Long manager;
    @JsonProperty("default_tester")
    String defaultTester;
    Long product;
    Long plan;
    Long build;
    @JsonProperty("start_date")
    String startDate;
    @JsonProperty("stop_date")
    String stopDate;
    @JsonProperty("planned_start")
    String plannedStart;
    @JsonProperty("planned_stop")
    String plannedStop;
    String notes;

}
