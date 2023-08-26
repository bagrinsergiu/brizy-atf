package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.link.file;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.FileUploader;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.link.tabs.file.FileTabLocators;
import com.microsoft.playwright.Frame;
import io.vavr.control.Try;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;
import org.apache.commons.lang3.StringUtils;

import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import static org.awaitility.Awaitility.await;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FileTab extends AbstractTabItem {

    Supplier<FileUploader> fileUploader;

    public FileTab(FileTabLocators fileTabLocators, Frame frame) {
        super(fileTabLocators.getConfigurations(), fileTabLocators.getSelf(), frame);
        this.fileUploader = () -> new FileUploader(fileTabLocators.getFile(), frame);
    }

    public void applyProperties(String file) {
        if (!file.isBlank() && !file.isEmpty()) {
            open();
            fileUploader.get().uploadFile(Paths.get(file));
        }
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.fileUploader).element(fileUploader).build()
        );
    }

    public String getFileName() {
        open();
        return Try.of(() ->
                await().atMost(2, TimeUnit.SECONDS)
                        .until(() -> fileUploader.get().getFileName(), value -> !value.isEmpty())
        ).getOrElse(StringUtils.EMPTY);
    }
}
