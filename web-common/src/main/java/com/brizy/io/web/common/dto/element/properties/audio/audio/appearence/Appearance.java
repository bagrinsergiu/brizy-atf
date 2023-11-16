package com.brizy.io.web.common.dto.element.properties.audio.audio.appearence;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Appearance {

    Boolean artwork;
    Boolean comments;
    Boolean playCounts;
    Boolean username;

}
