package com.brizy.io.web.interactions.page.editor.container.cms.assets;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.editor.cms.assets.CmsAssetsMenuLocators;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.abstracts.MenuItem;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.enums.AssetsMenuItems;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.pages.AssetsPages;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.posts.AssetsPosts;
import com.brizy.io.web.interactions.page.editor.container.cms.tab.CmsTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.stream.Stream;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CmsPopupAssetsMenu implements CmsTab {

    AssetsPages pages;
    AssetsPosts posts;
    Button opener;

    public CmsPopupAssetsMenu(CmsAssetsMenuLocators cmsPopUpLocatorsAssetsMenu, Frame frame) {
        this.pages = new AssetsPages(cmsPopUpLocatorsAssetsMenu.getPagesSection(), frame);
        this.posts = new AssetsPosts(cmsPopUpLocatorsAssetsMenu.getPostsSection(), frame);
        this.opener = new Button(frame.locator(cmsPopUpLocatorsAssetsMenu.getOpener()));
    }

    @Override
    public void open() {
        opener.click();
    }

    public MenuItem openMenuItem(AssetsMenuItems menuItem) {
        MenuItem foundMenuItem = Stream.of(pages, posts)
                .filter(page -> page.getName().equals(menuItem))
                .findFirst()
                .orElseThrow();
        foundMenuItem.open();
        return foundMenuItem;
    }

}
