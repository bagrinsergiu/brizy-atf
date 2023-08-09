package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.image.ImageProperties;
import com.brizy.io.web.common.dto.element.properties.image.image.align.Aligns;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.IsTabbedPopup;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.enumerable.EnumerableButton;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.Image;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.colors.Colors;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.map.settings.Settings;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.ToolbarProperties;
import com.microsoft.playwright.Frame;
import io.vavr.API;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.$;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ImageToolbar extends ComponentToolbar<ImageProperties> {

    Supplier<Button> imageButton;
    Supplier<Image> image;
    Supplier<Colors> colors;
    Supplier<Settings> settingsMenu;
    Supplier<EnumerableButton<Aligns>> align;

    public ImageToolbar(ToolbarProperties properties, Frame frame) {
        super(properties, frame);
        this.imageButton = () -> new Button(frame.locator(properties.getImage().getSelf()));
        this.image = () -> new Image(properties.getImage(), frame);
        this.colors = () -> new Colors(properties.getColors(), frame);
        this.settingsMenu = () -> new Settings(properties.getSettings(), frame);
        this.align = () -> new EnumerableButton<>(Aligns.values(), properties.getAlign(), frame);
    }

    protected Image openImage() {
        imageButton.get().click();
        return image.get();
    }

    @Override
    public IsTabbedPopup openTabbedPopup(String toolbarItemTitle) {
        return API.Match(toolbarItemTitle.toLowerCase()).of(
                API.Case($("image"), openImage()),
                API.Case($("colors"), () -> {
                    openColors();
                    return colors.get();
                })
        );
    }

    @Override
    public void setProperties(ImageProperties properties) {
        if (Objects.nonNull(properties)) {
            if (Objects.nonNull(properties.getImage())) {
                openImage().applyProperties(properties.getImage());
            }
            if (Objects.nonNull(properties.getColors())) {
                openColors();
                colors.get().applyProperties(properties.getColors());
            }
            if (Objects.nonNull(properties.getSettings())) {
                openSettings();
                settingsMenu.get().with(properties.getSettings());
            }
            if (Objects.nonNull(properties.getAlign())) {
                align.get().setValue(properties.getAlign());
            }
        }
    }

    @Override
    public EditorComponentProperty getProperties() {
        openImage();
        //TODO implement
        return null;
    }

}