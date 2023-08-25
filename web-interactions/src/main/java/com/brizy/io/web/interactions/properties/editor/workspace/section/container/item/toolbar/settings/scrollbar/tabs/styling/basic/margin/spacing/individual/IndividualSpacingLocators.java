package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.basic.margin.spacing.individual;

import com.brizy.io.web.interactions.properties.AbstractProperty;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.common.InputWithUnitsLocators;
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
public class IndividualSpacingLocators extends AbstractProperty {

    @NestedConfigurationProperty
    InputWithUnitsLocators top;
    @NestedConfigurationProperty
    InputWithUnitsLocators right;
    @NestedConfigurationProperty
    InputWithUnitsLocators bottom;
    @NestedConfigurationProperty
    InputWithUnitsLocators left;

}
