package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.audio.tabs.buttons;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ButtonsTabLocators extends AbstractLocator {

    String configurations;
    String like;
    String buy;
    String download;
    String share;

}
