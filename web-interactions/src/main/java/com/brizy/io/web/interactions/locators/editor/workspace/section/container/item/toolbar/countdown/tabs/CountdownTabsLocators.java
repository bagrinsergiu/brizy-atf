package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.countdown.tabs;

import com.brizy.io.web.interactions.locators.AbstractProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.countdown.tabs.advanced.AdvancedLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.countdown.tabs.timer.TimerLocators;
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
public class CountdownTabsLocators extends AbstractProperty {

    @NestedConfigurationProperty
    TimerLocators timer;
    @NestedConfigurationProperty
    AdvancedLocators advanced;

}
