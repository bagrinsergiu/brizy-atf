package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.common.settings.pop_up.SettingsWithWidthSidebarEffectsAndStylingProperties;
import com.brizy.io.web.common.dto.element.properties.playlist.PlaylistProperties;
import com.brizy.io.web.interactions.element.composite.EnumerableButton;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.Toolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up.SettingsPopUp;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up.SettingsWithWidthSidebarEffectsAndStyling;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.colors.Colors;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.playlist.Playlist;
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
public class PlaylistToolbar extends Toolbar<PlaylistProperties> {

    Supplier<Playlist> playlist;
    Supplier<Colors> colors;
    Supplier<SettingsPopUp<SettingsWithWidthSidebarEffectsAndStylingProperties>> settings;
    Supplier<EnumerableButton<Alignments>> align;

    public PlaylistToolbar(ToolbarLocators toolbarLocators, Frame frame) {
        super(toolbarLocators, frame);
        this.playlist = () -> new Playlist(toolbarLocators.getPlaylist(), frame);
        this.colors = () -> new Colors(toolbarLocators.getColors(), frame);
        this.settings = () -> new SettingsWithWidthSidebarEffectsAndStyling(toolbarLocators.getSettings(), frame);
        this.align = () -> new EnumerableButton<>(Alignments.class, toolbarLocators.getAlign(), frame);
    }

    @Override
    public PlaylistProperties getProperties() {
        return PlaylistProperties.builder()
                .align(align.get().getValue())
                .settings(settings.get().getProperties())
                .playlist(playlist.get().getProperties())
                .build();
    }

    @Override
    public IsToolbarItem openTabbedPopup(String toolbarItemTitle) {
        return API.Match(toolbarItemTitle.toLowerCase()).of(
                API.Case($(Fields.playlist), playlist),
                API.Case($(Fields.colors), colors)
        );
    }

    @Override
    public void setProperties(PlaylistProperties properties) {
        if (Objects.nonNull(properties.getAlign())) {
            align.get().setValue(properties.getAlign());
        }
        if (Objects.nonNull(properties.getPlaylist())) {
            playlist.get().applyProperties(properties.getPlaylist());
        }
        if (Objects.nonNull(properties.getSettings())) {
            settings.get().setProperties(properties.getSettings());
        }
    }

}