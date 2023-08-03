package com.brizy.io.web.kiwi.tcms.dto.request.test_execution;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class UpdateTestExecutionStatusDto {

    String status;
    @JsonProperty("stop_date")
    String stopDate;

}
