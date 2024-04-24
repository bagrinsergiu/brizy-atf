package com.brizy.io.web.interactions.page.publish.model;

import com.brizy.io.web.interactions.dto.editor.container.ComponentDimensionsDto;
import com.brizy.io.web.interactions.dto.editor.container.properties.Colors;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CssProperties {

    Colors colors;
    ComponentDimensionsDto dimension;

}
