package com.brizy.io.web.test.types.parameter_type;

import com.brizy.io.web.test.enums.AttributeTypes;
import io.cucumber.java.ParameterType;

public class AttributeType {

    @ParameterType(name = "attribute", value = "value|text")
    public AttributeTypes attribute(String rawValue) {
        if (rawValue.equals("value")) {
            return AttributeTypes.VALUE;
        }
        return AttributeTypes.TEXT;
    }

}
