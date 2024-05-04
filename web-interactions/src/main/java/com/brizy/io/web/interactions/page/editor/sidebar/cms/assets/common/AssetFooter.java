package com.brizy.io.web.interactions.page.editor.sidebar.cms.assets.common;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.Span;
import com.brizy.io.web.interactions.locators.editor.cms.assets.common.AssetsFooterLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AssetFooter {

    Span itemsCount;
    Button addNew;

    public AssetFooter(AssetsFooterLocators assetsFooterLocators, Frame frame) {
        this.addNew = new Button(frame.locator(assetsFooterLocators.getAddNew()));
        this.itemsCount = new Span(frame.locator(assetsFooterLocators.getItemsCount()));
    }

    public void addNew() {
        addNew.click();
    }

    public String getItemsCount() {
        return itemsCount.getText();
    }

}
