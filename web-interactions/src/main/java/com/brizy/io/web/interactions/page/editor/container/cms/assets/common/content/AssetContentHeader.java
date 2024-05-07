package com.brizy.io.web.interactions.page.editor.container.cms.assets.common.content;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.Span;
import com.brizy.io.web.interactions.locators.editor.cms.assets.common.content.AssetsContentHeaderLocators;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.common.content.enums.HeaderActions;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AssetContentHeader {

    Span title;
    Button back;
    Button close;

    public AssetContentHeader(AssetsContentHeaderLocators assetsHeaderLocators, Frame frame) {
        this.title = new Span(frame.locator(assetsHeaderLocators.getTitle()));
        this.back = new Button(frame.locator(assetsHeaderLocators.getBack()));
        this.close = new Button(frame.locator(assetsHeaderLocators.getClose()));
    }

    public String getTitle() {
        return title.getText(String.class);
    }

    void back() {
        back.click();
    }

    void close() {
        close.click();
    }

    public void clickOn(HeaderActions headerAction) {
        if (headerAction.equals(HeaderActions.BACK)) {
            back();
        }
        close();
    }

}
