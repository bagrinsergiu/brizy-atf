package com.brizy.io.web.common.dto.element.properties.playlist.playlist.playlist;

import com.brizy.io.web.common.dto.element.properties.common.InputWithUnitsProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Playlist {

    String position;
    String thumbs;
    InputWithUnitsProperties columns;

}
