package com.brizy.io.web.interactions.locators.editor;

import com.brizy.io.web.interactions.locators.editor.sidebar.EditorAddItemsSidebarProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class EditorSidebarLocators {

    String self;
    String cms;
    @NestedConfigurationProperty
    EditorAddItemsSidebarProperties addItems;

}
