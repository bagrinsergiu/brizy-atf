package com.brizy.io.web.interactions.element;

import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.image.tabs.image.ImageUploaderProperties;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.nio.file.Path;
import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class FileUploader implements Element {

    Page page;
    Supplier<Locator> uploader;
    Supplier<Button> delete;

    public FileUploader(Frame frame, ImageUploaderProperties image) {
        this.page = frame.page();
        this.uploader = () -> frame.locator(image.getUploader());
        this.delete = () -> new Button(frame.locator(image.getDelete()));
    }

    public void uploadFile(Path pathToFile) {
        FileChooser fileChooser = page.waitForFileChooser(() -> uploader.get().click());
        fileChooser.setFiles(pathToFile);
    }

    public void deleteUploadedFile() {
        delete.get().click();
    }

}
