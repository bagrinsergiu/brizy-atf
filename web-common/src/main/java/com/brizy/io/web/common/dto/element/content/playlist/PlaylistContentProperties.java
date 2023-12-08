package com.brizy.io.web.common.dto.element.content.playlist;

import com.brizy.io.web.common.dto.element.content.playlist.video.PlaylistVideoProperties;
import com.brizy.io.web.common.dto.element.type.Content;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
public class PlaylistContentProperties implements Content {

    String title;
    String subTitle;
    PlaylistVideoProperties properties;

}
