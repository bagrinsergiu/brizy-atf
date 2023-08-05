package com.brizy.io.web.kiwi.tcms.dto.request.test_case;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder(toBuilder = true)
public class UpdateTestCaseDurationDto {

    @JsonProperty("testing_duration")
    Long testingDuration;

}
