package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.image.tabs.image;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class FileUploaderLocators extends AbstractLocator {

    String uploader;
    String delete;
    String fileName;

}
