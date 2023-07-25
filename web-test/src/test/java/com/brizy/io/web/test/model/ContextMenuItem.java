package com.brizy.io.web.test.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

@Data
@Builder(toBuilder = true)
@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ContextMenuItem {

    String title;
    String keyShortcut;
    Boolean isEnabled;

}
