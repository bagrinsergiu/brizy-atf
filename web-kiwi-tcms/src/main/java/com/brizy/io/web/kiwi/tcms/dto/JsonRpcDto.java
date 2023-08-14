package com.brizy.io.web.kiwi.tcms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
public class JsonRpcDto {

    @Builder.Default
    @JsonProperty("jsonrpc")
    String jsonRpc = "2.0";
    @Builder.Default
    @JsonProperty("id")
    String id = "jsonrpc";

}
