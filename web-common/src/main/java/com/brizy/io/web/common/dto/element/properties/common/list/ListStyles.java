package com.brizy.io.web.common.dto.element.properties.common.list;

import com.brizy.io.web.common.dto.element.properties.common.Enumerable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum ListStyles implements Enumerable<ListStyles> {

    DEFAULT("nc-list-default"),
    NUMBERS("nc-list-numbers"),
    BULLET("nc-list-bullet");

    @Getter
    String value;

    @Override
    public ListStyles[] getValues() {
        return ListStyles.values();
    }
}
