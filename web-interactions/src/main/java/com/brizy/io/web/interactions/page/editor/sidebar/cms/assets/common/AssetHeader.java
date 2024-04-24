package com.brizy.io.web.interactions.page.editor.sidebar.cms.assets.common;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.locators.editor.sidebar.cms.assets.common.AssetsHeaderLocators;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AssetHeader {

    TextInput search;
    Button close;
    Button help;

    public AssetHeader(AssetsHeaderLocators assetsHeaderLocators, Page page) {
        this.search = new TextInput(page.locator(assetsHeaderLocators.getSearch()));
        this.close = new Button(page.locator(assetsHeaderLocators.getClose()));
        this.help = new Button(page.locator(assetsHeaderLocators.getHelp()));
    }

    public void searchFor(String searchForString) {
        search.fill(searchForString);
    }

}
