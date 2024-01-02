package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.playlist.tabs.playlist;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.InputWithUnitsLocators;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class PlaylistTabLocators extends AbstractLocator {

    String configurations;
    String position;
    String thumbs;
    InputWithUnitsLocators columns;

}
