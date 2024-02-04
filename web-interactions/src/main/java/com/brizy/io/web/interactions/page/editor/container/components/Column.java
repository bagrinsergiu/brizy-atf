package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.interactions.locators.editor.workspace.section.SectionLocators;
import com.brizy.io.web.interactions.page.editor.container.AbstractContainer;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
public class Column extends AbstractContainer {

    @Getter
    String name;

    public Column(Frame frame, Locator componentLocator, SectionLocators sectionLocators, int count) {
        super(sectionLocators, frame, componentLocator);
        this.name = "COLUMN_".concat(String.valueOf(count));
    }

}
