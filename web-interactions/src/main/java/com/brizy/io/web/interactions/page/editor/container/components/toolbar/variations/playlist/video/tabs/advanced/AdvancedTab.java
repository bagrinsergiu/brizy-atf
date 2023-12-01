package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.playlist.video.tabs.advanced;

import com.brizy.io.web.common.dto.element.content.playlist.video.video.advanced.AdvancedVideoContentProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.NumericInput;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.video.tabs.advanced.AdvancedTabLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AdvancedTab extends AbstractTabItem {

    Supplier<Slider> controls;
    Supplier<Slider> branding;
    Supplier<NumericInput> end;
    Supplier<Slider> loop;
    Supplier<Slider> intro;
    Supplier<NumericInput> start;

    public AdvancedTab(AdvancedTabLocators advancedTabLocators, Frame frame) {
        super(advancedTabLocators.getConfigurations(), advancedTabLocators.getSelf(), frame);
        this.controls = () -> new Slider(frame.locator(advancedTabLocators.getControls()));
        this.end = () -> new NumericInput(frame.locator(advancedTabLocators.getEnd()));
        this.loop = () -> new Slider(frame.locator(advancedTabLocators.getLoop()));
        this.intro = () -> new Slider(frame.locator(advancedTabLocators.getIntro()));
        this.branding = () -> new Slider(frame.locator(advancedTabLocators.getBranding()));
        this.start = () -> new NumericInput(frame.locator(advancedTabLocators.getStart()));
    }

    public void applyProperties(AdvancedVideoContentProperties AdvancedVideoContentProperties) {
        open();
        if (Objects.nonNull(AdvancedVideoContentProperties.getControls())) {
            controls.get().switchTo(AdvancedVideoContentProperties.getControls());
        }
        if (Objects.nonNull(AdvancedVideoContentProperties.getEnd())) {
            end.get().fill(AdvancedVideoContentProperties.getEnd());
        }
        if (Objects.nonNull(AdvancedVideoContentProperties.getLoop())) {
            loop.get().switchTo(AdvancedVideoContentProperties.getLoop());
        }
        if (Objects.nonNull(AdvancedVideoContentProperties.getBranding())) {
            branding.get().switchTo(AdvancedVideoContentProperties.getBranding());
        }
        if (Objects.nonNull(AdvancedVideoContentProperties.getStart())) {
            start.get().fill(AdvancedVideoContentProperties.getStart());
        }
    }

    public AdvancedVideoContentProperties getProperties() {
        open();
        return AdvancedVideoContentProperties.builder()
                .controls(controls.get().getState())
                .end(end.get().getValue(Integer.class))
                .loop(loop.get().getState())
                .branding(branding.get().getState())
                .start(start.get().getValue(Integer.class))
                .build();
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.controls).element(controls).build(),
                Configuration.builder().name(Fields.end).element(end).build(),
                Configuration.builder().name(Fields.loop).element(loop).build(),
                Configuration.builder().name(Fields.branding).element(branding).build(),
                Configuration.builder().name(Fields.start).element(start).build()
        );
    }

}
