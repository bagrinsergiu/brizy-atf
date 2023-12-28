package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.link.tabs.action;

import com.brizy.io.web.interactions.locators.AbstractProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.InputWithPopulationLocators;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ActionTabLocators extends AbstractProperty {

    String configurations;
    String whenFinished;
    InputWithPopulationLocators message;

}
