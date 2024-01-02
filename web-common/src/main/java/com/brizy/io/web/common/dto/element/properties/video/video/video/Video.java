package com.brizy.io.web.common.dto.element.properties.video.video.video;

import com.brizy.io.web.common.dto.element.properties.elements.InputWithPopulationProperties;
import com.brizy.io.web.common.dto.element.properties.video.video.video.player.Players;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Video {

    Players type;
    String ratio;
    InputWithPopulationProperties link;
    String file;

}
