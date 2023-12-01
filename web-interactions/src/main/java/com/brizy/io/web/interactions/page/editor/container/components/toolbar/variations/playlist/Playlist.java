package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.playlist;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.playlist.PlaylistLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.playlist.tabs.PlaylistTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.$;
import static io.vavr.API.Case;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Playlist extends AbstractToolbarItem {

    Supplier<PlaylistTab> playlist;

    public Playlist(PlaylistLocators playlistLocators, Frame frame) {
        super(playlistLocators.getSelf(), playlistLocators.getTabs().getSelf(), frame);
        this.playlist = () -> new PlaylistTab(playlistLocators.getTabs().getPlaylist(), frame);
    }

    public void applyProperties(com.brizy.io.web.common.dto.element.properties.playlist.playlist.Playlist playlistProperties) {
        if (Objects.nonNull(playlistProperties.getPlaylist())) {
            playlist.get().applyProperties(playlistProperties.getPlaylist());
        }
    }

    public com.brizy.io.web.common.dto.element.properties.playlist.playlist.Playlist getProperties() {
        return com.brizy.io.web.common.dto.element.properties.playlist.playlist.Playlist.builder()
                .playlist(playlist.get().getProperties())
                .build();
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        return io.vavr.API.Match(tab.toLowerCase()).of(
                Case($(), playlist)
        );
    }
}
