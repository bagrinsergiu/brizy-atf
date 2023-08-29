package com.brizy.io.web.test.types.parameter_type;

import com.brizy.io.web.test.enums.AttributeTypes;
import com.brizy.io.web.test.enums.RadioGroupActions;
import io.cucumber.java.ParameterType;

public class RadioGroupAction {

    @ParameterType(name = "radioGroupAction", value = "active|all|selected")
    public RadioGroupActions radioGroupAction(String rawValue) {
        if (rawValue.equals("all")) {
            return RadioGroupActions.ALL;
        }
        return RadioGroupActions.ACTIVE;
    }

}
