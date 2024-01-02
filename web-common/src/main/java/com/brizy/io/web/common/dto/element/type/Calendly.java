package com.brizy.io.web.common.dto.element.type;

import com.brizy.io.web.common.dto.element.properties.calendly.CalendlyProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Calendly extends AbstractPropertyType<CalendlyProperties> implements ItemType {

    @Getter
    CalendlyProperties properties;

}
