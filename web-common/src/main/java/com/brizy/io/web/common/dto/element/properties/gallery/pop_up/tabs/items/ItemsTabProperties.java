package com.brizy.io.web.common.dto.element.properties.gallery.pop_up.tabs.items;

import com.brizy.io.web.common.dto.element.properties.elements.InputWithUnitsProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ItemsTabProperties {

    InputWithUnitsProperties columns;
    InputWithUnitsProperties spacing;

}