package com.brizy.io.web.common.dto.element.content.playlist.video.video.video;

import com.brizy.io.web.common.dto.element.properties.playlist.playlist.player.Players;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class VideoContentProperties {

    Players type;
    String link;

}
