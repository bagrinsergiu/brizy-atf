package com.brizy.io.web.common.dto.element.properties.calendly.calendly;

import com.brizy.io.web.common.dto.element.properties.calendly.calendly.calendly.CalendlyTabProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CalendlyPopUpProperties {

    CalendlyTabProperties calendly;

}
