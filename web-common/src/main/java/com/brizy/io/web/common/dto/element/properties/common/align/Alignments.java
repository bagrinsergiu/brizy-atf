package com.brizy.io.web.common.dto.element.properties.common.align;

import com.brizy.io.web.common.dto.element.properties.common.Enumerable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum Alignments implements Enumerable<Alignments> {

    LEFT("align-left"),
    RIGHT("align-right"),
    CENTER("align-center"),
    JUSTIFY("align-justify");

    @Getter
    String value;

    @Override
    public Alignments[] getValues() {
        return Alignments.values();
    }

}
