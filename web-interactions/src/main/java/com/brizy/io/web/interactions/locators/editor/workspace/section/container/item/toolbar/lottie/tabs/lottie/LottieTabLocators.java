package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.lottie.tabs.lottie;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.InputWithUnitsLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.image.tabs.image.FileUploaderLocators;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class LottieTabLocators extends AbstractLocator {

    String configurations;
    String lottieLink;
    FileUploaderLocators lottieFile;
    String renderer;
    String autoplay;
    String reverse;
    String loop;
    InputWithUnitsLocators speed;

}
