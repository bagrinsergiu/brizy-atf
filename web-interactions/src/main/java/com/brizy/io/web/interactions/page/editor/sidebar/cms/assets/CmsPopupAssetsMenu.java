package com.brizy.io.web.interactions.page.editor.sidebar.cms.assets;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.editor.sidebar.cms.assets.CmsAssetsMenuLocators;
import com.brizy.io.web.interactions.page.editor.sidebar.cms.assets.pages.AssetsPages;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CmsPopupAssetsMenu {

    AssetsPages pages;
    Button pagesButton;
    Button postsButton;

    public CmsPopupAssetsMenu(CmsAssetsMenuLocators cmsPopUpLocatorsAssetsMenu, Page page) {
        this.pages = new AssetsPages(cmsPopUpLocatorsAssetsMenu.getPagesSection(), page);
        this.pagesButton = new Button(page.locator(cmsPopUpLocatorsAssetsMenu.getPages()));
        this.postsButton = new Button(page.locator(cmsPopUpLocatorsAssetsMenu.getPosts()));
    }

//    add method to click on pages button and return AssetsPages


    public Object openPosts() {
        postsButton.click();
        return null;
    }

}
