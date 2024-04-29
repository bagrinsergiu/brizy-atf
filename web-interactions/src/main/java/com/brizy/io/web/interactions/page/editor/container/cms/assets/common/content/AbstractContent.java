package com.brizy.io.web.interactions.page.editor.container.cms.assets.common.content;

import com.brizy.io.web.interactions.locators.editor.cms.assets.common.content.AbstractAssetContentLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class AbstractContent implements Content {

    AssetContentFooter assetContentFooter;
    AssetContentHeader assetContentHeader;

    public AbstractContent(AbstractAssetContentLocators abstractAssetContentLocators, Frame frame) {
        this.assetContentFooter = new AssetContentFooter(abstractAssetContentLocators.getFooter(), frame);
        this.assetContentHeader = new AssetContentHeader(abstractAssetContentLocators.getHeader(), frame);
    }

    public AssetContentFooter onFooter() {
        return assetContentFooter;
    }

    public AssetContentHeader onHeader() {
        return assetContentHeader;
    }

}
