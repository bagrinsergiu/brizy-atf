package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar;

import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.ColorsProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ToolbarProperties {

    @NestedConfigurationProperty
    ColorsProperties colors;

}
