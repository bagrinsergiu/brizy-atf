package com.brizy.io.web.common.dto.element.properties.button.settings.effects;

import com.brizy.io.web.common.dto.element.properties.button.settings.effects.entrance.EntranceProperties;
import com.brizy.io.web.common.dto.element.properties.button.settings.effects.hover.HoverProperties;
import com.brizy.io.web.common.dto.element.properties.button.settings.effects.scroll.ScrollProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EffectsProperties {

    EntranceProperties entrance;
    HoverProperties hover;
    ScrollProperties scroll;

}
