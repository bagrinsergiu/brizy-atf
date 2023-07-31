package com.brizy.io.web.common.dto.element.properties.toolbar.text.settings;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Settings implements com.brizy.io.web.common.dto.element.properties.toolbar.common.Settings {

    Integer gapAbove;
    Integer gapBelow;
    String htmlTag;

}
