package com.brizy.io.web.common.dto.element.properties.gallery.pop_up.tabs.gallery;

import com.brizy.io.web.common.dto.element.properties.elements.InputWithUnitsProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GalleryTabProperties {

    List<String> images;
    String layout;
    InputWithUnitsProperties height;
    String aspectRatio;
    Boolean enableTags;
    Boolean openInLightBox;

}