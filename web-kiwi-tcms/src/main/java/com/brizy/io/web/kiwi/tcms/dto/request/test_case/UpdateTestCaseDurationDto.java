package com.brizy.io.web.kiwi.tcms.dto.request.test_case;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class UpdateTestCaseDurationDto {

    @JsonProperty("testing_duration")
    Long testingDuration;

}
