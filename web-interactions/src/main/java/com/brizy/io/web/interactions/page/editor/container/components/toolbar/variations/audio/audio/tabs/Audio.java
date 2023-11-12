package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs;

import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.audio.AudioTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class Audio extends AbstractToolbarItem {

    public Audio(String tabOpenerLocator, String tabsLocator, Frame frame) {
        super(tabOpenerLocator, tabsLocator, frame);
    }

    public abstract AudioTab getAudio();

}