package com.brizy.io.web.common.dto.element.properties.video.video.player;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Player {

    String coverImage;
    Boolean controls;
    Boolean branding;
    Boolean lazyLoad;
    Boolean privacyMode;

}
