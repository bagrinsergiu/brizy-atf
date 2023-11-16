package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.audio;

import com.brizy.io.web.common.dto.element.properties.audio.audio.audio.type.Styles;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.element.composite.InputWithPopulation;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.audio.tabs.audio.AudioTabLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@FieldNameConstants
public class SoundCloudAudioTab extends AudioTab {

    Supplier<InputWithPopulation> link;
    Supplier<RadioControl<Styles>> style;
    Supplier<Slider> autoplay;

    public SoundCloudAudioTab(AudioTabLocators audioTabLocators, Frame frame) {
        super(audioTabLocators, frame);
        this.link = () -> new InputWithPopulation(audioTabLocators.getLink(), frame);
        this.style = () -> new RadioControl<>(Styles.class, audioTabLocators.getStyle(), frame);
        this.autoplay = () -> new Slider(frame.locator(audioTabLocators.getAutoplay()));
    }

    @Override
    public List<Configuration> getConfigurations() {
        var commonConfigurations = super.getConfigurations();
        List<Configuration> configurations = new ArrayList<>() {
            {
                add(Configuration.builder().name(Fields.link).element(link).build());
                add(Configuration.builder().name(Fields.style).element(style).build());
                add(Configuration.builder().name(Fields.autoplay).element(autoplay).build());
            }
        };
        configurations.addAll(commonConfigurations);
        return configurations;
    }

}
