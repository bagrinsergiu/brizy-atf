package com.brizy.io.web.common.dto.element.properties.line.pop_up;

import com.brizy.io.web.common.dto.element.properties.line.pop_up.tabs.icon.IconTabProperties;
import com.brizy.io.web.common.dto.element.properties.line.pop_up.tabs.line.LineTabProperties;
import com.brizy.io.web.common.dto.element.properties.line.pop_up.tabs.text.TextTabProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LinePopUpProperties {

    IconTabProperties icon;
    LineTabProperties line;
    TextTabProperties text;

}
