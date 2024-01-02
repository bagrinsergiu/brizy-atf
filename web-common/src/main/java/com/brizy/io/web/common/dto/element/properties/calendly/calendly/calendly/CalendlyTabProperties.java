package com.brizy.io.web.common.dto.element.properties.calendly.calendly.calendly;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CalendlyTabProperties {

    String link;

}
