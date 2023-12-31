package com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.effects.hover.types;

import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.effects.hover.HoverProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NoneHoverProperties implements HoverProperties {

    String value;

}
