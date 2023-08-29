package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.image.ImageProperties;
import com.brizy.io.web.interactions.element.composite.EnumerableButton;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.colors.Colors;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.image.Image;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.map.settings.Settings;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.microsoft.playwright.Frame;
import io.vavr.API;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.$;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@FieldNameConstants
public class ImageToolbar extends ComponentToolbar<ImageProperties> {

    Supplier<Image> image;
    Supplier<Colors> colors;
    Supplier<Settings> settingsMenu;
    Supplier<EnumerableButton<Alignments>> align;

    public ImageToolbar(ToolbarLocators properties, Frame frame) {
        super(properties, frame);
        this.image = () -> new Image(properties.getImage(), frame);
        this.colors = () -> new Colors(properties.getColors(), frame);
        this.settingsMenu = () -> new Settings(properties.getSettings(), frame);
        this.align = () -> new EnumerableButton<>(Alignments.class, properties.getAlign(), frame);
    }

    @Override
    public IsToolbarItem openTabbedPopup(String toolbarItemTitle) {
        return API.Match(toolbarItemTitle.toLowerCase()).of(
                API.Case($(Fields.image), image),
                API.Case($(Fields.colors), colors)
        );
    }

    @Override
    public void setProperties(ImageProperties properties) {
        if (Objects.nonNull(properties)) {
            if (Objects.nonNull(properties.getImage())) {
                image.get().applyProperties(properties.getImage());
            }
            if (Objects.nonNull(properties.getColors())) {
                colors.get().applyProperties(properties.getColors());
            }
            if (Objects.nonNull(properties.getSettings())) {
                settingsMenu.get().with(properties.getSettings());
            }
            if (Objects.nonNull(properties.getAlign())) {
                align.get().setValue(properties.getAlign());
            }
        }
    }

    @Override
    public ImageProperties getProperties() {
        return ImageProperties.builder()
                .image(image.get().getProperties())
                .colors(colors.get().getProperties())
                .settings(settingsMenu.get().getProperties())
                .build();
    }

}