package com.brizy.io.web.interactions.page.editor.sidebar.cms.assets.common;

import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.abstracts.TableContentDto;
import com.brizy.io.web.interactions.locators.editor.cms.assets.common.AbstractAssetsLocators;
import com.brizy.io.web.interactions.page.editor.sidebar.cms.assets.common.content.Content;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class AbstractAsset {

    AssetFooter footer;
    AssetHeader header;

    public AbstractAsset(AbstractAssetsLocators pagesSection, Frame frame) {
        this.footer = new AssetFooter(pagesSection.getFooter(), frame);
        this.header = new AssetHeader(pagesSection.getHeader(), frame);
    }

    public AssetFooter onFooter() {
        return footer;
    }

    public AssetHeader onHeader() {
        return header;
    }

    public abstract TableContentDto getTableData();

    public abstract Content addNew();

}
