package com.brizy.io.web.test.steps.actions;

import com.brizy.io.web.interactions.locators.WebLocatorsProperties;
import com.brizy.io.web.interactions.locators.editor.EditorPageLocators;
import com.brizy.io.web.interactions.page.editor.EditorPage;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.service.ActivePageService;
import com.brizy.io.web.test.storage.Storage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.When;
import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.brizy.io.web.test.enums.StorageKey.PAGE_SECTIONS;
import static java.util.List.of;
import static org.awaitility.Awaitility.await;


@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorPageSteps {

    ActivePageService activePageService;
    EditorPageLocators editorPageLocators;
    Storage storage;

    @Autowired
    public EditorPageSteps(ActivePageService activePageService, WebLocatorsProperties webLocatorsProperties, Storage storage) {
        this.activePageService = activePageService;
        this.editorPageLocators = webLocatorsProperties.getEditor();
        this.storage = storage;
    }

    @When("open editor pop up")
    public void openEditorPopUp() {
        EditorPage editorPage = storage.getValue(StorageKey.EDITOR, EditorPage.class);
        editorPage.onPageBuilder()._do().and().openPopUpMenu();
    }

    @When("^switch to '(.*)' tab$")
    public void switchToBlocksTab(String tab) {
        EditorPage editorPage = storage.getValue(StorageKey.EDITOR, EditorPage.class);
        editorPage.onPopUpMenu().switchToTab(tab);
    }

    @When("^add section '(.*)' to page$")
    public void addSectionToPage(String sectionName) {
        List<String> addedSections = new ArrayList<>(of(sectionName));
        EditorPage editorPage = storage.getValue(StorageKey.EDITOR, EditorPage.class);
        editorPage.onPopUpMenu().createYourOwn();
        editorPage.onPageBuilder()._do().addSection(sectionName);
        Option.of(storage.getValue(PAGE_SECTIONS, List.class))
                .peek(addedSections::addAll)
                .onEmpty(() -> storage.addValue(PAGE_SECTIONS, addedSections));
    }

    @When("wait for editor page to load")
    public void waitForEditorPageToLoad() {
        Page page = activePageService.getPage();
        EditorPage editorPage = new EditorPage(editorPageLocators, page);
        storage.addValue(StorageKey.EDITOR, editorPage);
        storage.addValue(StorageKey.EDITOR_PAGE, page);
    }

    @When("wait for an alert popup to show")
    public void waitForAnAlertPopupToShow() {
        EditorPage editorPage = storage.getValue(StorageKey.EDITOR, EditorPage.class);
        Try.of(editorPage::waitForAlertToAppear).onFailure(s -> Assertions.fail("No displayed alerts"));
    }

    @When("get alerts displayed on the page")
    public void getAlertsDisplayedOnThePage() {
        EditorPage editorPage = storage.getValue(StorageKey.EDITOR, EditorPage.class);
        storage.addValue(StorageKey.ALERTS, editorPage.getAlerts());
    }

    @When("wait for file uploading to finish")
    public void waitForFileUploadingEffect() {
        await().pollDelay(Duration.ofSeconds(2)).until(() -> true);
    }

}