package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.link.pop_up;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.FileUploader;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.link.tabs.pop_up.PopupTabLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;
import org.apache.logging.log4j.util.Strings;

import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PopupTab extends AbstractTabItem {

    Supplier<FileUploader> fileUploader;

    public PopupTab(PopupTabLocators popupTabLocators, Frame frame) {
        super(popupTabLocators.getConfigurations(), popupTabLocators.getSelf(), frame);
        this.fileUploader = () -> new FileUploader(popupTabLocators.getPopUp(), frame);
    }

    public void applyProperties(String popUp) {
        if (Objects.nonNull(popUp) && !popUp.isBlank()) {
            open();
            fileUploader.get().uploadFile(Paths.get(popUp));
        }
    }

    public String getProperties() {
        open();
        return Strings.EMPTY;
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.fileUploader).element(fileUploader).build()
        );
    }
}
