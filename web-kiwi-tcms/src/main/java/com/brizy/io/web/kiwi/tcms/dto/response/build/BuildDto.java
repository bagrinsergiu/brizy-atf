package com.brizy.io.web.kiwi.tcms.dto.response.build;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BuildDto {

    Long id;
    String name;
    Long version;
    @JsonProperty("version__value")
    String versionValue;
    @JsonProperty("is_active")
    Boolean isAction;

}
