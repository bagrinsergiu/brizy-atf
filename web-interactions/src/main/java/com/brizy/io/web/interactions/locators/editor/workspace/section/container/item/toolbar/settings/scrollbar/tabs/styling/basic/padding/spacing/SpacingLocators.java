package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.basic.padding.spacing;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.InputWithUnitsLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.basic.padding.spacing.individual.IndividualSpacingLocators;
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
public class SpacingLocators {

    @NestedConfigurationProperty
    InputWithUnitsLocators all;
    @NestedConfigurationProperty
    IndividualSpacingLocators individual;


}
