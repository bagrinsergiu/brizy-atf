package com.brizy.io.web.interactions.page.editor.container.cms.assets.common.content;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.editor.cms.assets.common.content.AssetsContentFooterLocators;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.common.content.enums.FooterActions;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AssetContentFooter {

    Button cancel;
    Button saveChanges;

    public AssetContentFooter(AssetsContentFooterLocators assetsFooterLocators, Frame frame) {
        this.cancel = new Button(frame.locator(assetsFooterLocators.getCancel()));
        this.saveChanges = new Button(frame.locator(assetsFooterLocators.getSaveChanges()));
    }

    void cancel() {
        cancel.click();
    }

    void save() {
        saveChanges.click();
    }

    public void clickOn(FooterActions footerActions) {
        if (footerActions.equals(FooterActions.CANCEL)) {
            cancel();
        }
        save();
    }

}
