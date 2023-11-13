package com.brizy.io.web.common.dto.element.properties.audio.audio;

import com.brizy.io.web.common.dto.element.properties.audio.audio.appearence.Appearance;
import com.brizy.io.web.common.dto.element.properties.audio.audio.buttons.Buttons;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Audio {

    com.brizy.io.web.common.dto.element.properties.audio.audio.audio.Audio audio;
    Appearance appearance;
    Buttons buttons;

}
