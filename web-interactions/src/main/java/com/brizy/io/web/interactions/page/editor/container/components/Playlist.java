package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.playlist.PlaylistProperties;
import com.brizy.io.web.common.dto.element.type.Content;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.content.variations.playlist.PlaylistContent;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.PlaylistToolbar;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class Playlist extends ComponentWithContent<PlaylistProperties> {

    PlaylistToolbar toolbar;
    Supplier<Button> borderButton;
    Supplier<PlaylistContent> playlistContent;

    public Playlist(ItemLocators itemLocators, Frame frame, Locator locator) {
        super(frame, locator, itemLocators);
        this.toolbar = new PlaylistToolbar(itemLocators.getToolbar(), frame);
        this.borderButton = () -> new Button(frame.locator(itemLocators.getBorderButton()));
        this.playlistContent = () -> new PlaylistContent(itemLocators, frame, locator);
    }

    @Override
    public PlaylistProperties getEditorProperties() {
        return toolbar.getProperties();
    }

    @Override
    protected void openToolbar() {
        borderButton.get().click();
    }

    @Override
    public <Type extends Content> void configureContents(List<Type> content) {
        playlistContent.get().setContent(content);
    }

}
