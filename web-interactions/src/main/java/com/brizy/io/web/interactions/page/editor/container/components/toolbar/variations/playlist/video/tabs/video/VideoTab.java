package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.playlist.video.tabs.video;

import com.brizy.io.web.common.dto.element.content.playlist.video.video.video.VideoContentProperties;
import com.brizy.io.web.common.dto.element.properties.playlist.playlist.player.Players;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.video.tabs.video.VideoTabLocators;
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
public class VideoTab extends AbstractTabItem {

    Supplier<ComboBox> type;
    Supplier<TextInput> link;

    public VideoTab(VideoTabLocators videoTabLocators, Frame frame) {
        super(videoTabLocators.getConfigurations(), videoTabLocators.getSelf(), frame);
        this.type = () -> new ComboBox(frame.locator(videoTabLocators.getType()));
        this.link = () -> new TextInput(frame.locator(videoTabLocators.getUrl()));
    }

    public void applyProperties(VideoContentProperties videoTabProperties) {
        open();
        if (Objects.nonNull(videoTabProperties.getType())) {
            type.get().selectItemByName(videoTabProperties.getType().getValue());
        }
        if (Objects.nonNull(videoTabProperties.getLink())) {
            link.get().fill(videoTabProperties.getLink());
        }
    }

    public VideoContentProperties getProperties() {
        open();
        return VideoContentProperties.builder()
                .link(link.get().getRawValue())
                .type(Players.valueOf(type.get().getSelectedItem().toUpperCase()))
                .build();
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(VideoTab.Fields.type).element(type).build(),
                Configuration.builder().name(VideoTab.Fields.link).element(link).build()
        );
    }

}
