package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.video.tabs;

import com.brizy.io.web.interactions.locators.AbstractProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.video.tabs.advanced.AdvancedTabLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.video.tabs.cover.CoverTabLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.video.tabs.playback.PlaybackTabLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.video.tabs.player.PlayerTabLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.video.tabs.video.VideoTabLocators;
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
public class VideoTabsLocators extends AbstractProperty {

    @NestedConfigurationProperty
    AdvancedTabLocators advanced;
    @NestedConfigurationProperty
    CoverTabLocators cover;
    @NestedConfigurationProperty
    VideoTabLocators video;
    @NestedConfigurationProperty
    PlayerTabLocators player;
    @NestedConfigurationProperty
    PlaybackTabLocators playback;

}
