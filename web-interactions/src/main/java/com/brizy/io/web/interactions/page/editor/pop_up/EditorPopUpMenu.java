package com.brizy.io.web.interactions.page.editor.pop_up;

import com.brizy.io.web.interactions.locators.editor.EditorPopUpMenuLocators;
import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class EditorPopUpMenu {

    EditorPopUpMenuHeader header;
    EditorPopUpMenuBody body;

    public EditorPopUpMenu(EditorPopUpMenuLocators properties, Page page) {
        this.header = new EditorPopUpMenuHeader(properties.getHeader(), page);
        this.body = new EditorPopUpMenuBody(properties.getBody(), page);
    }

    public void switchToTab(String tabName) {
        Tab tab = header.getTab(tabName);
        tab.select();
    }

    public void createYourOwn() {
        body.createYourOwn();
    }

}
