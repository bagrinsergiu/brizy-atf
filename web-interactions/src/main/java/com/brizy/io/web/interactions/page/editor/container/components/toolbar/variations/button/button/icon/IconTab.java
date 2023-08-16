package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.icon;

import com.brizy.io.web.common.dto.element.properties.button.button.icon.IconTabProperties;
import com.brizy.io.web.common.dto.element.properties.button.button.icon.align.IconAligns;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.FileUploader;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.IsTab;
import com.brizy.io.web.interactions.element.composite.EnumerableButton;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.icon.size.IconSize;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.button.tabs.icon.IconProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class IconTab implements IsTab {

    @Getter
    Supplier<Button> tabButton;
    Supplier<FileUploader> icon;
    Supplier<RadioControl<IconAligns>> position;
    Supplier<IconSize> size;

    public IconTab(IconProperties iconLocators, Frame frame) {
        this.tabButton = () -> new Button(frame.locator(iconLocators.getSelf()));
        this.icon = () -> new FileUploader(iconLocators.getIcon(), frame);
        this.position = () -> new RadioControl<>(IconAligns.class, iconLocators.getPosition(), frame);
        this.size = () -> new IconSize(iconLocators.getSize(), frame);
    }

    public void applyProperties(IconTabProperties propertiesToApply) {
        open();
        if (Objects.nonNull(propertiesToApply.getIcon())) {
//            TODO refactor to get item from the window
//            icon.get().uploadFile(Paths.get(propertiesToApply.getIcon()));
        }
        if (Objects.nonNull(propertiesToApply.getAlign())) {
            position.get().set(propertiesToApply.getAlign());
        }
        if (Objects.nonNull(propertiesToApply.getSize())) {
            size.get().applyProperties(propertiesToApply.getSize());
        }
    }

    @Override
    public List<String> getWebConfigurations() {
        return null;
    }

    @Override
    public List<Configuration> getConfigurations() {
        return null;
    }

}
