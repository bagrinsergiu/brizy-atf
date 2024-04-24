package com.brizy.io.web.interactions.page.editor.sidebar.cms.assets.common;

import com.brizy.io.web.interactions.locators.editor.sidebar.cms.assets.common.AbstractAssetsLocators;
import com.brizy.io.web.interactions.locators.editor.sidebar.cms.assets.pages.AssetsPagesSectionLocators;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class AbstractAsset {

    AssetFooter footer;
    AssetHeader header;

    public AbstractAsset(AbstractAssetsLocators pagesSection, Page page) {
        this.footer = new AssetFooter(pagesSection.getFooter(), page);
        this.header = new AssetHeader(pagesSection.getHeader(), page);
    }

    public void addNew() {
        footer.addNew();
    }

}
