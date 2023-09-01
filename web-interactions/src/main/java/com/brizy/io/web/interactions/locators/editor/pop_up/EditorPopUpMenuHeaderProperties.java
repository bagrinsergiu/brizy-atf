package com.brizy.io.web.interactions.locators.editor.pop_up;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class EditorPopUpMenuHeaderProperties {

    String self;
    String search;
    @NestedConfigurationProperty
    EditorPopUpMenuHeaderTabsProperties tabs;

}
