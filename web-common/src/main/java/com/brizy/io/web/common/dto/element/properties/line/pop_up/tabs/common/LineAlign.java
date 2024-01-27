package com.brizy.io.web.common.dto.element.properties.line.pop_up.tabs.common;

import com.brizy.io.web.common.dto.element.properties.common.Enumerable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum LineAlign implements Enumerable<LineAlign> {

    LEFT("nc-line-align-left"),
    CENTER("nc-line-align-center"),
    RIGHT("nc-line-align-right");

    @Getter
    String value;

    @Override
    public LineAlign[] getValues() {
        return LineAlign.values();
    }

}
