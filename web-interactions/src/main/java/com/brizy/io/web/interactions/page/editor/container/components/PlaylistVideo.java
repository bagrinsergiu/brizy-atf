package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.content.playlist.video.PlaylistVideoProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.PlaylistVideoToolbar;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter(value = AccessLevel.PROTECTED)
public class PlaylistVideo extends Component<PlaylistVideoProperties> {

    PlaylistVideoToolbar toolbar;

    public PlaylistVideo(ItemLocators itemLocators, Frame frame, Locator locator) {
        super(frame, locator, itemLocators);
        this.toolbar = new PlaylistVideoToolbar(itemLocators.getToolbar(), frame);
    }

    @Override
    public PlaylistVideoProperties getEditorProperties() {
        return toolbar.getProperties();
    }

}
