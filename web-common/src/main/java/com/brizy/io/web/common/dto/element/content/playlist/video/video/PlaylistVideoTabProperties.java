package com.brizy.io.web.common.dto.element.content.playlist.video.video;

import com.brizy.io.web.common.dto.element.content.playlist.video.video.advanced.AdvancedVideoContentProperties;
import com.brizy.io.web.common.dto.element.content.playlist.video.video.cover.CoverVideoContentProperties;
import com.brizy.io.web.common.dto.element.content.playlist.video.video.video.VideoContentProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
public class PlaylistVideoTabProperties {

    VideoContentProperties video;
    AdvancedVideoContentProperties advanced;
    CoverVideoContentProperties cover;

}
