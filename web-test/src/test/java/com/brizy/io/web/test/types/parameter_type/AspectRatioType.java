package com.brizy.io.web.test.types.parameter_type;

import com.brizy.io.web.test.model.AspectRatio;
import io.cucumber.java.ParameterType;

public class AspectRatioType {

    @ParameterType(name = "aspectRatio", value = "\\d+:\\d+")
    public AspectRatio attribute(String rawValue) {
        var split = rawValue.split(":");
        return AspectRatio.builder()
                .width(Double.parseDouble(split[0].trim()))
                .height(Double.parseDouble(split[1].trim()))
                .build();
    }

}
