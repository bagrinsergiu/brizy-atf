package com.brizy.io.web.interactions.page.editor.sidebar.cms;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.editor.sidebar.cms.EditorSidebarCmsPopUpLocators;
import com.brizy.io.web.interactions.page.editor.sidebar.cms.assets.CmsPopupAssetsMenu;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorSidebarCmsPopup {

    CmsPopupAssetsMenu assetsMenu;
    Button menu;
    public EditorSidebarCmsPopup(EditorSidebarCmsPopUpLocators cmsPopUpLocators, Page page) {
        this.assetsMenu = new CmsPopupAssetsMenu(cmsPopUpLocators.getAssetsMenu(), page);
        this.menu = new Button(page.locator(cmsPopUpLocators.getMenu()));
    }

//    add methods to click on buttons : assets, menu, project settings.
//    similar to com.brizy.io.web.interactions.page.editor.sidebar.cms.EditorSidebarCmsPopup:openCms()
//    add only for assets for now, should return a CmsPopupAssetsMenu

    public Object openMenu() {
        menu.click();
        return null;
    }

}
