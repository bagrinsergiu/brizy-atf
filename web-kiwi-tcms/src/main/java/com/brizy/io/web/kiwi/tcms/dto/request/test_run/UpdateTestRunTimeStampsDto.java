package com.brizy.io.web.kiwi.tcms.dto.request.test_run;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class UpdateTestRunTimeStampsDto {

    @JsonProperty("stop_date")
    String stopDate;
    @JsonProperty("planned_stop")
    String plannedStop;

}
