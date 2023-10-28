package com.brizy.io.web.common.dto.element.properties.gallery.tabs.items;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ItemsTabProperties {

    Integer columns;
    Integer spacing;


}
