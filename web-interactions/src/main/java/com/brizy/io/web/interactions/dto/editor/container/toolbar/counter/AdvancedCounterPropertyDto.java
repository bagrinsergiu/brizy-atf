package com.brizy.io.web.interactions.dto.editor.container.toolbar.counter;

import com.brizy.io.web.common.dto.element.properties.common.InputWithPopulationProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AdvancedCounterPropertyDto {

    InputWithPopulationProperties prefix;
    InputWithPopulationProperties suffix;
    InputWithPopulationProperties separator;

}
