package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.type;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.audio.AudioLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.Audio;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.advanced.AdvancedTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.audio.AudioTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.audio.CustomAudioTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.cover.CoverTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.function.Supplier;

import static io.vavr.API.$;
import static io.vavr.API.Case;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@FieldNameConstants
public class CustomAudioType extends Audio {

    Supplier<CustomAudioTab> audio;
    Supplier<CoverTab> cover;
    Supplier<AdvancedTab> advanced;

    public CustomAudioType(AudioLocators audioLocators, Frame frame) {
        super(audioLocators.getSelf(), audioLocators.getTabs().getSelf(), frame);
        var tabsLocators = audioLocators.getTabs();
        this.audio = () -> new CustomAudioTab(tabsLocators.getAudio(), frame);
        this.cover = () -> new CoverTab(tabsLocators.getCover(), frame);
        this.advanced = () -> new AdvancedTab(tabsLocators.getAdvanced(), frame);
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        open();
        return io.vavr.API.Match(tab.toLowerCase()).of(
                Case($(Fields.audio), audio),
                Case($(Fields.advanced), advanced),
                Case($(), cover)
        );
    }

    @Override
    public AudioTab getAudio() {
        return audio.get();
    }
}
