package com.brizy.io.web.kiwi.tcms.dto.request.build;

import com.brizy.io.web.kiwi.tcms.dto.JsonRpcDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder(toBuilder = true)
public class CreateBuildRequestDto extends JsonRpcDto {

    @Builder.Default
    @JsonProperty("method")
    String method = "";

    @Builder.Default
    @JsonProperty("params")
    List<CreateBuildDto> params = null;

}
