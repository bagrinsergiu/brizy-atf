package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.advanced;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.audio.tabs.advanced.AdvancedTabLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@FieldNameConstants
public class AdvancedTab extends AbstractTabItem {

    Supplier<Slider> time;
    Supplier<Slider> duration;
    Supplier<Slider> progress;
    Supplier<Slider> volume;

    public AdvancedTab(AdvancedTabLocators advancedTabLocators, Frame frame) {
        super(advancedTabLocators.getConfigurations(), advancedTabLocators.getSelf(), frame);
        this.time = () -> new Slider(frame.locator(advancedTabLocators.getTime()));
        this.duration = () -> new Slider(frame.locator(advancedTabLocators.getDuration()));
        this.progress = () -> new Slider(frame.locator(advancedTabLocators.getProgress()));
        this.volume = () -> new Slider(frame.locator(advancedTabLocators.getVolume()));
    }

    @Override
    public List<Configuration> getConfigurations() {
        open();
        return List.of(
                Configuration.builder().name(Fields.duration).element(duration).build(),
                Configuration.builder().name(Fields.time).element(time).build(),
                Configuration.builder().name(Fields.progress).element(progress).build(),
                Configuration.builder().name(Fields.volume).element(volume).build()
        );
    }
}
