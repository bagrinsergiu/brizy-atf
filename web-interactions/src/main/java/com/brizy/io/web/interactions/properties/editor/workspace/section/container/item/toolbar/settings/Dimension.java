package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.settings;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Dimension {

    String value;
    @NestedConfigurationProperty
    Unit unit;

}
