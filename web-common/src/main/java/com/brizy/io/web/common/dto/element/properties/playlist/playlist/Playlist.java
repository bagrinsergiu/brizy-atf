package com.brizy.io.web.common.dto.element.properties.playlist.playlist;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Playlist {

    com.brizy.io.web.common.dto.element.properties.playlist.playlist.playlist.Playlist playlist;

}
