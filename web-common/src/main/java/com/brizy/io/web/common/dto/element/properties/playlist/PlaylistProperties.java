package com.brizy.io.web.common.dto.element.properties.playlist;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.common.settings.pop_up.SettingsWithWidthSidebarEffectsAndStylingProperties;
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

    Alignments align;
    Playlist playlist;
    SettingsWithWidthSidebarEffectsAndStylingProperties settings;

}
