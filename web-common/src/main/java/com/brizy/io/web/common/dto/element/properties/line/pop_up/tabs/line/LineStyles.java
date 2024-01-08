package com.brizy.io.web.common.dto.element.properties.line.pop_up.tabs.line;

import com.brizy.io.web.common.dto.element.properties.common.Enumerable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum LineStyles implements Enumerable<LineStyles> {

    SOLID("nc-line-solid"),
    TEXT("nc-line-text"),
    ICON("nc-line-icon");

    @Getter
    String value;

    @Override
    public LineStyles[] getValues() {
        return LineStyles.values();
    }

}
