package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.link.pop_up;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.FileUploader;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.IsTab;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.link.tabs.pop_up.PopupTabLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PopupTab implements IsTab {

    @Getter
    Supplier<Button> tabButton;
    Supplier<FileUploader> fileUploader;

    public PopupTab(PopupTabLocators popupTabLocators, Frame frame) {
        this.fileUploader = () -> new FileUploader(popupTabLocators.getPopUp(), frame);
        this.tabButton = () -> new Button(frame.locator(popupTabLocators.getSelf()));
    }

    public void applyProperties(String popUp) {
        if (Objects.nonNull(popUp) && !popUp.isBlank()) {
            open();
            fileUploader.get().uploadFile(Paths.get(popUp));
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
