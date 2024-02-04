package com.brizy.io.web.interactions.page.editor.container;

import com.brizy.io.web.interactions.locators.editor.workspace.section.SectionLocators;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@SuppressWarnings("all")
public class Section extends AbstractContainer {

    public Section(SectionLocators sectionLocators, Frame frame, Locator locator) {
        super(sectionLocators, frame, locator);
    }

}