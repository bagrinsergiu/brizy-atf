package com.brizy.io.web.common.dto.element.properties.progress_bar.progress_bar;

import com.brizy.io.web.common.dto.element.properties.progress_bar.progress_bar.progress_bar.ProgressBarTabProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProgressBarProperties {

    ProgressBarTabProperties progress;

}
