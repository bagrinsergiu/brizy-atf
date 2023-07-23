package com.brizy.io.web.test.types.parameter_type;

import com.brizy.io.web.interactions.enums.ContextMenuActions;
import io.cucumber.java.ParameterType;

public class ContextMenuActionParameterType {

    @ParameterType(name = "contextMenuAction", value = "copy|paste|paste styles|duplicate|delete")
    public ContextMenuActions contextMenuAction(String rawValue) {
        return ContextMenuActions.getByValue(rawValue.toUpperCase());
    }

}
