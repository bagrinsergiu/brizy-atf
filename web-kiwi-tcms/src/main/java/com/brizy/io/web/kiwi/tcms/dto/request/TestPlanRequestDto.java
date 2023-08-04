package com.brizy.io.web.kiwi.tcms.dto.request;

import com.brizy.io.web.kiwi.tcms.dto.JsonRpcDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public class TestPlanRequestDto extends JsonRpcDto {

    @Builder.Default
    @JsonProperty("method")
    String method = "";
    @Builder.Default
    @JsonProperty("params")
    TestPlanDto params = null;

}
