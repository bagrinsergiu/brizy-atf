package com.brizy.io.web.common.dto.element.content.playlist.video;

import com.brizy.io.web.common.dto.element.content.playlist.video.video.PlaylistVideoTabProperties;
import com.brizy.io.web.common.dto.element.properties.Property;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
public class PlaylistVideoProperties implements Property {

    PlaylistVideoTabProperties video;

}
