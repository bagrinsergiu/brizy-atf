package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.lottie;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.lottie.tabs.LottieTabsLocators;
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
public class LottieLocators extends AbstractLocator {

    @NestedConfigurationProperty
    LottieTabsLocators tabs;

}
