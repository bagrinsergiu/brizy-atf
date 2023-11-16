package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.type;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.audio.AudioLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.Audio;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.appearance.AppearanceTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.audio.AudioTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.audio.SoundCloudAudioTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.buttons.ButtonsTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.function.Supplier;

import static io.vavr.API.$;
import static io.vavr.API.Case;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@FieldNameConstants
public class SoundCloudAudioType extends Audio {

    Supplier<SoundCloudAudioTab> audio;
    Supplier<AppearanceTab> appearance;
    Supplier<ButtonsTab> buttons;

    public SoundCloudAudioType(AudioLocators audioLocators, Frame frame) {
        super(audioLocators.getSelf(), audioLocators.getTabs().getSelf(), frame);
        var tabsLocators = audioLocators.getTabs();
        this.audio = () -> new SoundCloudAudioTab(tabsLocators.getAudio(), frame);
        this.appearance = () -> new AppearanceTab(tabsLocators.getAppearance(), frame);
        this.buttons = () -> new ButtonsTab(tabsLocators.getButtons(), frame);
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        open();
        return io.vavr.API.Match(tab.toLowerCase()).of(
                Case($(Fields.audio), audio),
                Case($(Fields.buttons), buttons),
                Case($(), appearance)
        );
    }

    @Override
    public AudioTab getAudio() {
        return audio.get();
    }

}
