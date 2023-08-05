package com.brizy.io.web.kiwi.tcms.dto.request.classification;

import com.brizy.io.web.kiwi.tcms.dto.JsonRpcDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder(toBuilder = true)
public class ClassificationByNameRequestDto extends JsonRpcDto {

    @Builder.Default
    @JsonProperty("method")
    String method = "";

    @Builder.Default
    @JsonProperty("params")
    List<ClassificationByNameDto> params = null;

}
