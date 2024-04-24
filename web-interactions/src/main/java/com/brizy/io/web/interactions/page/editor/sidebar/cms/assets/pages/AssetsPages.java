package com.brizy.io.web.interactions.page.editor.sidebar.cms.assets.pages;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.Table;
import com.brizy.io.web.interactions.locators.editor.sidebar.cms.assets.pages.AssetsPagesSectionLocators;
import com.brizy.io.web.interactions.page.editor.sidebar.cms.assets.common.AbstractAsset;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AssetsPages extends AbstractAsset {

    Button
    Table table;

    public AssetsPages(AssetsPagesSectionLocators pagesSection, Page page) {
        super(pagesSection, page);
        this.table = new Table(pagesSection.getMain().getTable(), page);
    }


}
