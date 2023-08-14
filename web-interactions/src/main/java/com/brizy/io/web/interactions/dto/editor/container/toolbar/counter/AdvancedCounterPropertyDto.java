package com.brizy.io.web.interactions.dto.editor.container.toolbar.counter;

import lombok.AccessLevel;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@ToString
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AdvancedCounterPropertyDto {

    String prefix;
    String suffix;
    String separator;

    public AdvancedCounterPropertyDto(String prefix, String suffix, String separator) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.separator = separator;
    }

}
