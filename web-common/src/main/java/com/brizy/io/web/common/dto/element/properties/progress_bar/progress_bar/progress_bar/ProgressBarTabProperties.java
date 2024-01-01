package com.brizy.io.web.common.dto.element.properties.progress_bar.progress_bar.progress_bar;

import com.brizy.io.web.common.dto.element.properties.common.InputWithPopulationProperties;
import com.brizy.io.web.common.dto.element.properties.progress_bar.enums.ProgressBarStyles;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProgressBarTabProperties {

    ProgressBarStyles style;
    InputWithPopulationProperties fill;
    Boolean title;
    Boolean percentage;

}
