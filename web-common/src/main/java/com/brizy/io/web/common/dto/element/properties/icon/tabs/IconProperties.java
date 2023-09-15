package com.brizy.io.web.common.dto.element.properties.icon.tabs;

import com.brizy.io.web.common.dto.element.properties.icon.tabs.background.BackgroundTabProperties;
import com.brizy.io.web.common.dto.element.properties.icon.tabs.icon.IconTabProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class IconProperties {

    IconTabProperties icon;
    BackgroundTabProperties background;

}
