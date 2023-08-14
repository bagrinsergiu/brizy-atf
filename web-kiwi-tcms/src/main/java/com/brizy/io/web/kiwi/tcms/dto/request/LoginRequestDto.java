package com.brizy.io.web.kiwi.tcms.dto.request;

import com.brizy.io.web.kiwi.tcms.dto.JsonRpcDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder(toBuilder = true)
public class LoginRequestDto extends JsonRpcDto {

    @Builder.Default
    @JsonProperty("method")
    String method = "";
    @JsonProperty("params")
    LoginDto params;

}
