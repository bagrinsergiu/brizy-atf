package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.audio;

import com.brizy.io.web.common.dto.element.properties.audio.audio.audio.type.IconSizes;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.FileUploader;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.audio.tabs.audio.AudioTabLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@FieldNameConstants
public class CustomAudioTab extends AudioTab {

    Supplier<FileUploader> fileUploader;
    Supplier<RadioControl<IconSizes>> icons;
    Supplier<Slider> loop;

    public CustomAudioTab(AudioTabLocators audioTabLocators, Frame frame) {
        super(audioTabLocators, frame);
        this.fileUploader = () -> new FileUploader(audioTabLocators.getFile(), frame);
        this.icons = () -> new RadioControl<>(IconSizes.class, audioTabLocators.getIcons(), frame);
        this.loop = () -> new Slider(frame.locator(audioTabLocators.getLoop()));
    }

    @Override
    public List<Configuration> getConfigurations() {
        open();
        var commonConfigurations = super.getConfigurations();
        List<Configuration> configurations = List.of(
                Configuration.builder().name("file uploader").element(fileUploader).build(),
                Configuration.builder().name(Fields.icons).element(icons).build(),
                Configuration.builder().name(Fields.loop).element(loop).build()
        );
        configurations.addAll(commonConfigurations);
        return configurations;
    }

}
