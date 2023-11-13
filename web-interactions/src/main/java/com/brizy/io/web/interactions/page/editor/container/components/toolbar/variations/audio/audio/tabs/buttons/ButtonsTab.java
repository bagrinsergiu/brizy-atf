package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.buttons;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.audio.tabs.buttons.ButtonsTabLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@FieldNameConstants
public class ButtonsTab extends AbstractTabItem {

    Supplier<Slider> like;
    Supplier<Slider> buy;
    Supplier<Slider> download;
    Supplier<Slider> share;

    public ButtonsTab(ButtonsTabLocators buttonsTabLocators, Frame frame) {
        super(buttonsTabLocators.getConfigurations(), buttonsTabLocators.getSelf(), frame);
        this.like = () -> new Slider(frame.locator(buttonsTabLocators.getLike()));
        this.buy = () -> new Slider(frame.locator(buttonsTabLocators.getBuy()));
        this.download = () -> new Slider(frame.locator(buttonsTabLocators.getDownload()));
        this.share = () -> new Slider(frame.locator(buttonsTabLocators.getShare()));
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.like).element(like).build(),
                Configuration.builder().name(Fields.buy).element(buy).build(),
                Configuration.builder().name(Fields.download).element(download).build(),
                Configuration.builder().name(Fields.share).element(share).build()
        );
    }

}
