package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.carousel.tabs;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.carousel.tabs.carousel.CarouselTabLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.carousel.tabs.navigation.NavigationTabLocators;
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
public class CarouselTabsLocators extends AbstractLocator {

    @NestedConfigurationProperty
    CarouselTabLocators carousel;
    @NestedConfigurationProperty
    NavigationTabLocators navigation;

}
