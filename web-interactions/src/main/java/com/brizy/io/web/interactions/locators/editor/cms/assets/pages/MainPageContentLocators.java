package com.brizy.io.web.interactions.locators.editor.cms.assets.pages;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.DropDownLocators;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class MainPageContentLocators extends AbstractLocator {

    String title;
    String slug;
    String description;
    @NestedConfigurationProperty
    DropDownLocators published;

}
