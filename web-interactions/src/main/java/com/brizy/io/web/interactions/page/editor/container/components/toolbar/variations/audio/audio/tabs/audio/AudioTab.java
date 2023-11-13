package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.audio;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.audio.tabs.audio.AudioTabLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
@FieldNameConstants
public abstract class AudioTab extends AbstractTabItem {

    Supplier<ComboBox> audio;

    public AudioTab(AudioTabLocators audioTabLocators, Frame frame) {
        super(audioTabLocators.getConfigurations(), audioTabLocators.getSelf(), frame);
        this.audio = () -> new ComboBox(frame.locator(audioTabLocators.getAudio()));
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.audio).element(audio).build()
        );
    }

}
