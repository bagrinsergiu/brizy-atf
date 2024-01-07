package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.video.tabs.playback;

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
public class PlaybackTabLocators extends AbstractLocator {

    String autoplay;
    String muted;
    String loop;
    String suggestedVideos;
    String start;
    String end;
    String configurations;

}
