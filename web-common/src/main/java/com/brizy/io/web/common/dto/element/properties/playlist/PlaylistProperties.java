package com.brizy.io.web.common.dto.element.properties.playlist;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.playlist.playlist.Playlist;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PlaylistProperties implements Property {

    Playlist playlist;

}
