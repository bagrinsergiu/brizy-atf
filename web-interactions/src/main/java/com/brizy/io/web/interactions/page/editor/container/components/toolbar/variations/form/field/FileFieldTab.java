package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.field;

import com.brizy.io.web.common.dto.element.properties.form.field.type.FileFieldProperty;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.FieldLocator;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FileFieldTab extends AbstractRequiredFieldTab {

    Supplier<TextInput> allowedFileType;
    Supplier<TextInput> fileSizeErrorMessage;
    Supplier<TextInput> fileTypeErrorMessage;
    Supplier<ComboBox> maxFileSize;

    public FileFieldTab(FieldLocator field, Frame frame) {
        super(field, frame);
        this.allowedFileType = () -> new TextInput(frame.locator(field.getAllowedFileTypes()));
        this.fileSizeErrorMessage = () -> new TextInput(frame.locator(field.getFileSizeErrorMessage()));
        this.fileTypeErrorMessage = () -> new TextInput(frame.locator(field.getFileTypeErrorMessage()));
        this.maxFileSize = () -> new ComboBox(frame.locator(field.getMaxFileSize()));
    }

    public void applyProperties(FileFieldProperty fieldsProperties) {
        super.applyProperties(fieldsProperties);
        if (Objects.nonNull(fieldsProperties.getConfiguration())) {
            var configuration = fieldsProperties.getConfiguration();
            if (Objects.nonNull(configuration.getFileSize())) {
                maxFileSize.get().selectItemByName(configuration.getFileSize());
            }
            if (Objects.nonNull(configuration.getAllowedExtensions())) {
                allowedFileType.get().fill(configuration.getAllowedExtensions());
            }
            if (Objects.nonNull(configuration.getErrorMessage())) {
                var errorMessage = configuration.getErrorMessage();
                if (Objects.nonNull(errorMessage.getFileSizeErrorMessage())) {
                    fileSizeErrorMessage.get().fill(errorMessage.getFileSizeErrorMessage());
                }
                if (Objects.nonNull(errorMessage.getFileTypeErrorMessage())) {
                    fileTypeErrorMessage.get().fill(errorMessage.getFileTypeErrorMessage());
                }
            }
        }
    }

}
