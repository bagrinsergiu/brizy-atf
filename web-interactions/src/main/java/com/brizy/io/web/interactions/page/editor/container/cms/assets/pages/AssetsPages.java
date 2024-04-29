package com.brizy.io.web.interactions.page.editor.container.cms.assets.pages;

import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.abstracts.TableContentDto;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.editor.cms.assets.pages.AssetsPagesSectionLocators;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.abstracts.MenuItem;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.common.AbstractAsset;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.common.content.Content;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.enums.AssetsMenuItems;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.pages.content.NewPageContent;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.pages.table.PagesTable;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AssetsPages extends AbstractAsset implements MenuItem {

    Button opener;
    PagesTable table;
    Supplier<NewPageContent> newPage;

    public AssetsPages(AssetsPagesSectionLocators pagesSection, Frame frame) {
        super(pagesSection, frame);
        this.opener = new Button(frame.locator(pagesSection.getOpener()));
        this.table = new PagesTable(pagesSection.getMain().getTable(), frame);
        this.newPage = () -> new NewPageContent(pagesSection.getContent(), frame);
    }

    @Override
    public TableContentDto getTableData() {
        return table.getData();
    }

    @Override
    public void open() {
        opener.click();
    }

    @Override
    public AssetsMenuItems getName() {
        return AssetsMenuItems.PAGES;
    }

    @Override
    public Content addNew() {
        super.onFooter().addNew();
        return newPage.get();
    }

}
