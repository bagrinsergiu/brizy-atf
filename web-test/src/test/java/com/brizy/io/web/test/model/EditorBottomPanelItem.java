package com.brizy.io.web.test.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder(toBuilder = true)
@FieldNameConstants
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class EditorBottomPanelItem {

    String name;
    String tooltip;
    Boolean isEnabled;

}
