package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.appearance;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.audio.tabs.appearance.AppearanceTabLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@FieldNameConstants
public class AppearanceTab extends AbstractTabItem {

    Supplier<Slider> artwork;
    Supplier<Slider> comments;
    Supplier<Slider> playCounts;
    Supplier<Slider> username;

    public AppearanceTab(AppearanceTabLocators appearanceTabLocators, Frame frame) {
        super(appearanceTabLocators.getConfigurations(), appearanceTabLocators.getSelf(), frame);
        this.artwork = () -> new Slider(frame.locator(appearanceTabLocators.getArtwork()));
        this.comments = () -> new Slider(frame.locator(appearanceTabLocators.getComments()));
        this.playCounts = () -> new Slider(frame.locator(appearanceTabLocators.getPlayCounts()));
        this.username = () -> new Slider(frame.locator(appearanceTabLocators.getUsername()));
    }

    @Override
    public List<Configuration> getConfigurations() {
        open();
        return List.of(
                Configuration.builder().name(Fields.artwork).element(artwork).build(),
                Configuration.builder().name(Fields.comments).element(comments).build(),
                Configuration.builder().name(Fields.playCounts).element(playCounts).build(),
                Configuration.builder().name(Fields.username).element(username).build()
        );
    }

}
