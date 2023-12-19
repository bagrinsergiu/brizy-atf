package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.rating.tabs;

import com.brizy.io.web.interactions.locators.AbstractProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.rating.tabs.icons.IconsTabLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.rating.tabs.rating.RatingTabLocators;
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
public class RatingTabsLocators extends AbstractProperty {

    @NestedConfigurationProperty
    IconsTabLocators icons;
    @NestedConfigurationProperty
    RatingTabLocators rating;

}