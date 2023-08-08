package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.nio.file.Path;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class FileUploader {

    Locator locator;

    public void uploadFile(Path pathToFile) {
        locator.setInputFiles(pathToFile);
    }

}
