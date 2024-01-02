package com.brizy.io.web.common.dto.element.properties.alert;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.alert.alert.AlertTabProperties;
import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.common.settings.pop_up.SettingsWithWidthEffectsAndStylingProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AlertProperties implements Property {

    Alignments align;
    AlertTabProperties alert;
    SettingsWithWidthEffectsAndStylingProperties settings;

}
