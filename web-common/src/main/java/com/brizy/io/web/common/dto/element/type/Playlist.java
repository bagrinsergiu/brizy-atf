package com.brizy.io.web.common.dto.element.type;

import com.brizy.io.web.common.dto.element.content.playlist.PlaylistContentProperties;
import com.brizy.io.web.common.dto.element.properties.playlist.PlaylistProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class Playlist extends AbstractPropertyType<PlaylistProperties> implements ItemTypeWithContent {

    PlaylistProperties properties;

    PlaylistContentProperties[] content;

}