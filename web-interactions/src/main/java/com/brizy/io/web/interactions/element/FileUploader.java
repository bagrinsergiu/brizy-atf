package com.brizy.io.web.interactions.element;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.image.tabs.image.FileUploaderLocators;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class FileUploader extends AbstractElement implements Element {

    Page page;
    Supplier<Locator> uploader;
    Supplier<Button> delete;
    Supplier<Span> fileName;

    public FileUploader(FileUploaderLocators image, Frame frame) {
        super(frame.locator(image.getSelf()));
        this.page = frame.page();
        this.uploader = () -> frame.locator(image.getUploader());
        this.delete = () -> new Button(frame.locator(image.getDelete()));
        this.fileName = () -> new Span(frame.locator(image.getFileName()));
    }

    public void uploadFile(Path pathToFile) {
        FileChooser fileChooser = page.waitForFileChooser(() -> uploader.get().click());
        fileChooser.setFiles(pathToFile);
    }

    public void uploadFiles(List<Path> pathToFile) {
        pathToFile.forEach(this::uploadFile);
    }

    public void deleteUploadedFile() {
        delete.get().click();
    }

    public String getFileName() {
        return fileName.get().getText();
    }
}
