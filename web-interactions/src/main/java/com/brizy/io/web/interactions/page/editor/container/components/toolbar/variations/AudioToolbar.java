package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.audio.AudioProperties;
import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.common.settings.pop_up.SettingsWithWidthHeightEffectsAndStylingProperties;
import com.brizy.io.web.interactions.element.composite.EnumerableButton;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.Toolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up.SettingsPopUp;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up.SettingsWithWidthHeightEffectsAndStyling;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.factory.AudioFactory;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.Audio;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.colors.Colors;
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
public class AudioToolbar extends Toolbar<AudioProperties> {

    Supplier<Audio> audio;
    Supplier<Colors> colors;
    Supplier<SettingsPopUp<SettingsWithWidthHeightEffectsAndStylingProperties>> settings;
    Supplier<EnumerableButton<Alignments>> align;

    public AudioToolbar(ToolbarLocators properties, Frame frame) {
        super(properties, frame);
        this.audio = () -> AudioFactory.getAudioType(properties.getAudio(), frame);
        this.colors = () -> new Colors(properties.getColors(), frame);
        this.settings = () -> new SettingsWithWidthHeightEffectsAndStyling(properties.getSettings(), frame);
        this.align = () -> new EnumerableButton<>(Alignments.class, properties.getAlign(), frame);
    }

    @Override
    public IsToolbarItem openTabbedPopup(String toolbarItemTitle) {
        return API.Match(toolbarItemTitle.toLowerCase()).of(
                API.Case($(Fields.audio), audio),
                API.Case($(Fields.colors), colors),
                API.Case($(Fields.settings), settings)
        );
    }

    @Override
    public AudioProperties getProperties() {
        return AudioProperties.builder()
                .settings(settings.get().getProperties())
                .build();
    }

    @Override
    public void setProperties(AudioProperties properties) {
        if (Objects.nonNull(properties.getSettings())) {
            settings.get().setProperties(properties.getSettings());
        }
    }

}