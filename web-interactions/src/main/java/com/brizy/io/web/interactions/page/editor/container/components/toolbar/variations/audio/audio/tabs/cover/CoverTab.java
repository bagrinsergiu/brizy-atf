package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.audio.audio.tabs.cover;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.FileUploader;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.audio.tabs.cover.CoverTabLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.function.Supplier;


@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@FieldNameConstants
public class CoverTab extends AbstractTabItem {

    Supplier<FileUploader> cover;
    Supplier<InputWithUnits> zoom;

    public CoverTab(CoverTabLocators coverTabLocators, Frame frame) {
        super(coverTabLocators.getConfigurations(), coverTabLocators.getSelf(), frame);
        this.cover = () -> new FileUploader(coverTabLocators.getCover(), frame);
        this.zoom = () -> new InputWithUnits(coverTabLocators.getZoom(), frame);
    }

    @Override
    public List<Configuration> getConfigurations() {
        open();
        return List.of(
                Configuration.builder().name(Fields.cover).element(cover).build(),
                Configuration.builder().name(Fields.zoom).element(zoom).build()
        );
    }

}
