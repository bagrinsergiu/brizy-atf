package com.brizy.io.web.interactions.locators.editor.sidebar;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class EditorAddItemsSidebarProperties {

    String self;
    @NestedConfigurationProperty
    EditorAddItemsSidebarContentProperties content;

}
