package com.brizy.io.web.interactions.locators.editor;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.pop_up.EditorPopUpMenuBodyLocators;
import com.brizy.io.web.interactions.locators.editor.pop_up.EditorPopUpMenuHeaderLocators;
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
public class EditorPopUpMenuLocators extends AbstractLocator {

    @NestedConfigurationProperty
    EditorPopUpMenuHeaderLocators header;
    @NestedConfigurationProperty
    EditorPopUpMenuBodyLocators body;

}
