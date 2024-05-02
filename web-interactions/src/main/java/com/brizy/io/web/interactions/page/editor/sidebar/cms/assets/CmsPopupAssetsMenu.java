package com.brizy.io.web.interactions.page.editor.sidebar.cms.assets;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.editor.cms.assets.CmsAssetsMenuLocators;
import com.brizy.io.web.interactions.page.editor.sidebar.cms.assets.abstracts.MenuItem;
import com.brizy.io.web.interactions.page.editor.sidebar.cms.assets.enums.AssetsMenuItems;
import com.brizy.io.web.interactions.page.editor.sidebar.cms.assets.pages.AssetsPages;
import com.brizy.io.web.interactions.page.editor.sidebar.cms.tab.CmsTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.stream.Stream;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CmsPopupAssetsMenu implements CmsTab {

    AssetsPages pages;
    Button opener;
    Button pagesButton;
    Button postsButton;

    public CmsPopupAssetsMenu(CmsAssetsMenuLocators cmsPopUpLocatorsAssetsMenu, Frame frame) {
        this.pages = new AssetsPages(cmsPopUpLocatorsAssetsMenu.getPagesSection(), frame);
        this.opener = new Button(frame.locator(cmsPopUpLocatorsAssetsMenu.getOpener()));
        this.pagesButton = new Button(frame.locator(cmsPopUpLocatorsAssetsMenu.getPages()));
        this.postsButton = new Button(frame.locator(cmsPopUpLocatorsAssetsMenu.getPosts()));
    }

    @Override
    public void open() {
        opener.click();
    }

    public MenuItem openMenuItem(AssetsMenuItems menuItem) {
        return Stream.of(pages)
                .filter(page -> page.getName().equals(menuItem))
                .findFirst()
                .orElseThrow();
    }

}
