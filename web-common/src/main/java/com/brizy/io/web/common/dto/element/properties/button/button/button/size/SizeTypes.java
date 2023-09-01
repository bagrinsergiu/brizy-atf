package com.brizy.io.web.common.dto.element.properties.button.button.button.size;

import com.brizy.io.web.common.dto.element.properties.common.Enumerable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum SizeTypes implements Enumerable<SizeTypes> {

    SMALL("nc-small"),
    MEDIUM("nc-medium"),
    LARGE("nc-large"),
    CUSTOM("nc-more");

    @Getter
    String value;

    @Override
    public SizeTypes[] getValues() {
        return SizeTypes.values();
    }

}
