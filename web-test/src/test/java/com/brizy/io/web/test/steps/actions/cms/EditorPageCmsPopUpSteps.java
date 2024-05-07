package com.brizy.io.web.test.steps.actions.cms;

import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.abstracts.NewContentDto;
import com.brizy.io.web.interactions.locators.WebLocatorsProperties;
import com.brizy.io.web.interactions.locators.editor.EditorPageLocators;
import com.brizy.io.web.interactions.page.editor.EditorPage;
import com.brizy.io.web.interactions.page.editor.container.cms.EditorCmsPopup;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.CmsPopupAssetsMenu;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.common.AbstractAsset;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.common.content.AbstractContent;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.common.content.Content;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.common.content.enums.FooterActions;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.common.content.enums.HeaderActions;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.enums.AssetsMenuItems;
import com.brizy.io.web.interactions.page.editor.container.cms.enums.CmsTabs;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.service.ActivePageService;
import com.brizy.io.web.test.storage.Storage;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;


@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorPageCmsPopUpSteps {

    ActivePageService activePageService;
    EditorPageLocators editorPageLocators;
    Storage storage;

    @Autowired
    public EditorPageCmsPopUpSteps(ActivePageService activePageService, WebLocatorsProperties webLocatorsProperties, Storage storage) {
        this.activePageService = activePageService;
        this.editorPageLocators = webLocatorsProperties.getEditor();
        this.storage = storage;
    }

    @When("open CMS pop up")
    public void openCmsPopUp() {
        EditorPage editorPage = storage.getValue(StorageKey.EDITOR, EditorPage.class);
        var editorSidebarCmsPopup = editorPage.onPageBuilder()._do().openCms();
        storage.addValue(StorageKey.CMS_POP_UP, editorSidebarCmsPopup);
    }

    @When("open CMS '{cmsTab}' tab")
    public void openCMSAssetsTab(CmsTabs cmsTab) {
        var cmsPopUp = storage.getValue(StorageKey.CMS_POP_UP, EditorCmsPopup.class);
        var openedTab = cmsPopUp.openTab(cmsTab);
        storage.addValue(StorageKey.CMS_OPENED_TAB, openedTab);
    }

    @When("open '{assetsMenuItem}' assets menu item")
    public void openAssetsMenuItem(AssetsMenuItems assetsMenuItem) {
        var cmsAssets = storage.getValue(StorageKey.CMS_OPENED_TAB, CmsPopupAssetsMenu.class);
        var menuItem = cmsAssets.openMenuItem(assetsMenuItem);
        storage.addValue(StorageKey.CMS_ASSETS_MENU_ITEM, menuItem);
    }

    @When("click on Add New Page button")
    public void clickOnAddNewAsset() {
        var cmsAsset = storage.getValue(StorageKey.CMS_ASSETS_MENU_ITEM, AbstractAsset.class);
        var content = cmsAsset.addNew();
        storage.addValue(StorageKey.CMS_ASSET_CONTENT, content);
    }

    @When("add the following details for the new page:")
    public void addTheFollowingDetailsToThePage(NewContentDto newContent) {
        var content = storage.getValue(StorageKey.CMS_ASSET_CONTENT, Content.class);
        content.fill(newContent);
        storage.addValue(StorageKey.TO_ASSERT_EXPECTED, newContent);
    }

    @When("click on '{footerNewContentButton}' button")
    public void clickSaveChangesButton(FooterActions footerAction) {
        var newContentPage = storage.getValue(StorageKey.CMS_ASSET_CONTENT, AbstractContent.class);
        newContentPage.onFooter().clickOn(footerAction);
    }

    @When("get the content of the pages table")
    public void getTheContentOfThePagesTable() {
        var cmsAsset = storage.getValue(StorageKey.CMS_ASSETS_MENU_ITEM, AbstractAsset.class);
        var tableData = cmsAsset.getTableData();
        storage.addValue(StorageKey.TO_ASSERT_ACTUAL, tableData);
    }

    @When("click on '{headerNewContentButton}' button")
    public void clickOnBackButton(HeaderActions headerAction) {
        var newContentPage = storage.getValue(StorageKey.CMS_ASSET_CONTENT, AbstractContent.class);
        newContentPage.onHeader().clickOn(headerAction);
    }
}