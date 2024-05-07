package com.brizy.io.web.interactions.page.editor.container.cms.assets.common;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.locators.editor.cms.assets.common.AssetsHeaderLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AssetHeader {

    TextInput search;
    Button close;
    Button help;

    public AssetHeader(AssetsHeaderLocators assetsHeaderLocators, Frame frame) {
        this.search = new TextInput(frame.locator(assetsHeaderLocators.getSearch()));
        this.close = new Button(frame.locator(assetsHeaderLocators.getClose()));
        this.help = new Button(frame.locator(assetsHeaderLocators.getHelp()));
    }

    public void searchFor(String searchForString) {
        search.fill(searchForString);
    }

}
