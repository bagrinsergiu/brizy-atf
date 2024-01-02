package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.content.playlist.sidebar;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.content.playlist.sidebar.item.PlaylistContentItemLocators;
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
public class PlaylistContentSidebarLocators extends AbstractLocator {

    String items;
    @NestedConfigurationProperty
    PlaylistContentItemLocators item;

}
