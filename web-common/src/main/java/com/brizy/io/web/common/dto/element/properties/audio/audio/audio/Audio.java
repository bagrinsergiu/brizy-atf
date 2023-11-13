package com.brizy.io.web.common.dto.element.properties.audio.audio.audio;

import com.brizy.io.web.common.dto.element.properties.audio.audio.audio.type.AudioSourceType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Audio {

    AudioSourceType type;

}
