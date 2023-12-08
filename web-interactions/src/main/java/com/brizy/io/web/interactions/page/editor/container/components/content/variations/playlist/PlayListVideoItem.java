package com.brizy.io.web.interactions.page.editor.container.components.content.variations.playlist;

import com.brizy.io.web.common.dto.element.content.playlist.PlaylistContentProperties;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.PlaylistVideo;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PlayListVideoItem {

    Supplier<TextInput> title;
    Supplier<TextInput> subTitle;
    Supplier<PlaylistVideo> videoItem;

    public PlayListVideoItem(ItemLocators contentLocators, Frame frame, Locator locator) {
        this.title = () -> new TextInput(locator.locator(contentLocators.getContent().getPlaylist().getSidebar().getItem().getTitle()));
        this.subTitle = () -> new TextInput(locator.locator(contentLocators.getContent().getPlaylist().getSidebar().getItem().getSubtitle()));
        this.videoItem = () -> new PlaylistVideo(contentLocators, frame, locator);
    }

    public void configure(PlaylistContentProperties playlistContentProperties) {
        if (Objects.nonNull(playlistContentProperties.getTitle())) {
            title.get().fill(playlistContentProperties.getTitle());
        }
        if (Objects.nonNull(playlistContentProperties.getSubTitle())) {
            subTitle.get().fill(playlistContentProperties.getSubTitle());
        }
        if (Objects.nonNull(playlistContentProperties.getProperties())) {
            videoItem.get().configure(playlistContentProperties.getProperties());
        }
    }

    public void delete() {
        videoItem.get().onToolbar().delete();
    }

    public void duplicate() {
        videoItem.get().onToolbar().duplicate();
    }

}
