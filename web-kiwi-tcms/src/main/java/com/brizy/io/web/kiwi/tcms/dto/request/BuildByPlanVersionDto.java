package com.brizy.io.web.kiwi.tcms.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class BuildByPlanVersionDto {

    @Builder.Default
    @JsonProperty("is_active")
    Boolean isActive = true;
    @Builder.Default
    @JsonProperty("version__plan")
    String planId = "";

}
