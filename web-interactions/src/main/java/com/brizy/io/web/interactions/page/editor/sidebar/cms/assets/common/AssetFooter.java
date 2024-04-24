package com.brizy.io.web.interactions.page.editor.sidebar.cms.assets.common;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.Span;
import com.brizy.io.web.interactions.locators.editor.sidebar.cms.assets.common.AssetsFooterLocators;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AssetFooter {

    Span itemsCount;
    Button addNew;

    public AssetFooter(AssetsFooterLocators assetsFooterLocators, Page page) {
        this.addNew = new Button(page.locator(assetsFooterLocators.getAddNew()));
        this.itemsCount = new Span(page.locator(assetsFooterLocators.getItemsCount()));
    }

    public void addNew() {
        addNew.click();
    }

    public String getItemsCount() {
        return itemsCount.getText();
    }

}
