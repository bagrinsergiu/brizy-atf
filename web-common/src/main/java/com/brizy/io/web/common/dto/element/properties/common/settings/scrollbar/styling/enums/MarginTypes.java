package com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.enums;

import com.brizy.io.web.common.dto.element.properties.common.Enumerable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum MarginTypes implements Enumerable<MarginTypes> {

    ALL("nc-styling-all"),
    INDIVIDUAL("nc-styling-individual");

    @Getter
    String value;

    @Override
    public MarginTypes[] getValues() {
        return MarginTypes.values();
    }

}
