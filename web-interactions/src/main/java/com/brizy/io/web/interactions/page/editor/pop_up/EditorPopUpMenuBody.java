package com.brizy.io.web.interactions.page.editor.pop_up;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.properties.editor.pop_up.EditorPopUpMenuBodyProperties;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorPopUpMenuBody {

    Supplier<Button> createYourOwn;

    public EditorPopUpMenuBody(EditorPopUpMenuBodyProperties properties, Page page) {
        this.createYourOwn = () -> new Button(page.locator(properties.getContent().getCreateYourOwn()));
    }

    //    TODO temporary solution, refactor
    public void createYourOwn() {
        createYourOwn.get().click();
    }
}
