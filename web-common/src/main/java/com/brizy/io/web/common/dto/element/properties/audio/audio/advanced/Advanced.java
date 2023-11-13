package com.brizy.io.web.common.dto.element.properties.audio.audio.advanced;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Advanced {

    Boolean time;
    Boolean duration;
    Boolean progress;
    Boolean volume;

}
