package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.factory;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.audio.AudioLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.Audio;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.type.CustomAudioType;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.type.SoundCloudAudioType;
import com.microsoft.playwright.Frame;

public final class AudioFactory {

    public static Audio getAudioType(AudioLocators audioLocators, Frame frame) {
        if (isCustomAudioType(frame, audioLocators)) {
            return new CustomAudioType(audioLocators, frame);
        }
        return new SoundCloudAudioType(audioLocators, frame);
    }

    private static boolean isCustomAudioType(Frame frame, AudioLocators audioLocators) {
        return frame.locator(audioLocators.getTabs().getSelf()).all()
                .stream()
                .anyMatch(locator -> locator.textContent().equalsIgnoreCase("cover"));
    }

}
