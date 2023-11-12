package com.brizy.io.web.common.dto.element.properties.audio.audio.audio.type;

import com.brizy.io.web.common.dto.element.properties.common.InputWithPopulationProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SoundCloud {

    String audio = "SoundCloud";
    Boolean autoplay;
    Styles style;
    InputWithPopulationProperties link;

}
