package com.brizy.io.web.interactions.dto.editor.container.toolbar.counter;

import lombok.AccessLevel;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@ToString(callSuper = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TextCounterPropertyDto extends CounterPropertyDto {

    Integer start;
    AdvancedCounterPropertyDto advanced;

    public TextCounterPropertyDto(Integer start, Integer end, Double duration, AdvancedCounterPropertyDto advanced) {
        super(end, duration);
        this.advanced = advanced;
        this.start = start;
    }

}
