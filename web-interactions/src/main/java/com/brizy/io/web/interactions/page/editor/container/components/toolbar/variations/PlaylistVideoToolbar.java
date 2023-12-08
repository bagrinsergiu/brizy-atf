package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.content.playlist.video.PlaylistVideoProperties;
import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.interactions.element.composite.EnumerableButton;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.colors.Colors;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.map.settings.Settings;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.playlist.video.tabs.PlaylistVideo;
import com.microsoft.playwright.Frame;
import io.vavr.API;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.$;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@FieldNameConstants
public class PlaylistVideoToolbar extends ComponentToolbar<PlaylistVideoProperties> {

    Supplier<PlaylistVideo> video;
    Supplier<Colors> colors;
    Supplier<Settings> settingsMenu;
    Supplier<EnumerableButton<Alignments>> align;

    public PlaylistVideoToolbar(ToolbarLocators properties, Frame frame) {
        super(properties, frame);
        this.video = () -> new PlaylistVideo(properties.getVideo(), frame);
        this.colors = () -> new Colors(properties.getColors(), frame);
        this.settingsMenu = () -> new Settings(properties.getSettings(), frame);
        this.align = () -> new EnumerableButton<>(Alignments.class, properties.getAlign(), frame);
    }

    @Override
    public IsToolbarItem openTabbedPopup(String toolbarItemTitle) {
        return API.Match(toolbarItemTitle.toLowerCase()).of(
                API.Case($(Fields.video), video),
                API.Case($(Fields.colors), colors)
        );
    }

    @Override
    public PlaylistVideoProperties getProperties() {
        return PlaylistVideoProperties.builder()
                .video(video.get().getProperties())
                .build();
    }

    @Override
    public void setProperties(PlaylistVideoProperties properties) {
        if (Objects.nonNull(properties)) {
            video.get().applyProperties(properties.getVideo());
        }
    }

}