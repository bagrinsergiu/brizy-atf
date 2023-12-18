package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.rating.tabs.icons;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.InputWithUnitsLocators;
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
public class IconsTabLocators extends IconTabLocators {

    @NestedConfigurationProperty
    InputWithUnitsLocators spacing;

}
