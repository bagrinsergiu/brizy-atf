package com.brizy.io.web.common.dto.element.properties.gallery.pop_up;

import com.brizy.io.web.common.dto.element.properties.gallery.pop_up.tabs.gallery.GalleryTabProperties;
import com.brizy.io.web.common.dto.element.properties.gallery.pop_up.tabs.items.ItemsTabProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GalleryPopUpProperties {

    GalleryTabProperties gallery;
    ItemsTabProperties items;

}