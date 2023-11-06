package com.brizy.io.web.common.dto.element.properties.video.video;

import com.brizy.io.web.common.dto.element.properties.video.video.playback.Playback;
import com.brizy.io.web.common.dto.element.properties.video.video.player.Player;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Video {

    com.brizy.io.web.common.dto.element.properties.video.video.video.Video video;
    Playback playback;
    Player player;
}
