package com.brizy.io.web.interactions.page.editor.sidebar.cms;

import com.brizy.io.web.interactions.locators.editor.cms.EditorCmsPopUpLocators;
import com.brizy.io.web.interactions.page.editor.sidebar.cms.assets.CmsPopupAssetsMenu;
import com.brizy.io.web.interactions.page.editor.sidebar.cms.enums.CmsTabs;
import com.brizy.io.web.interactions.page.editor.sidebar.cms.tab.CmsTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorCmsPopup {

    CmsPopupAssetsMenu assetsMenu;

    public EditorCmsPopup(EditorCmsPopUpLocators cmsPopUpLocators, Frame frame) {
        this.assetsMenu = new CmsPopupAssetsMenu(cmsPopUpLocators.getAssetsMenu(), frame);
    }

    public CmsTab openTab(CmsTabs cmsTab) {
        if (cmsTab.equals(CmsTabs.ASSETS)) {
            assetsMenu.open();
            return assetsMenu;
        }
//        TODO implement for menu
        return null;
    }

}
