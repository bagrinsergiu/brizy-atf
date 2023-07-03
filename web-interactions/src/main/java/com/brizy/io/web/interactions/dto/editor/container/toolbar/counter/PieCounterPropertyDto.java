package com.brizy.io.web.interactions.dto.editor.container.toolbar.counter;

import lombok.AccessLevel;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@ToString(callSuper = true)
public class PieCounterPropertyDto extends CounterPropertyDto {

    public PieCounterPropertyDto(Integer end, Double duration) {
        super(end, duration);
    }

}
