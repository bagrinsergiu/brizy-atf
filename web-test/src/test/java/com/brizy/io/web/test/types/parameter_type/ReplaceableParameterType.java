package com.brizy.io.web.test.types.parameter_type;

import io.cucumber.java.ParameterType;

import java.time.LocalDateTime;

public class ReplaceableParameterType {

    @ParameterType(name = "replaceablePattern", value = ".*")
    public String getType(String rawValue) {
        return rawValue.replaceAll("@timestamp@", LocalDateTime.now().toString());
    }

}
