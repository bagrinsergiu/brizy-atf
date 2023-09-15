package com.brizy.io.web.common.dto.element.properties.common.settings.settings.styling.enums;

import com.brizy.io.web.common.dto.element.properties.common.Enumerable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum PaddingTypes implements Enumerable<PaddingTypes> {

    ALL("nc-styling-all"),
    INDIVIDUAL("nc-styling-individual");

    @Getter
    String value;

    @Override
    public PaddingTypes[] getValues() {
        return PaddingTypes.values();
    }

}
