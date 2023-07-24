package com.brizy.io.web.kiwi.tcms.dto.request.version;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class VersionByNameDto {

    @Builder.Default
    @JsonProperty("value")
    String value = "";

}
