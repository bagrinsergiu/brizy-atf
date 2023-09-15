package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.link;

import com.brizy.io.web.common.dto.element.properties.button.link.LinkProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.link.LinkLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.link.tabs.LinkTabsLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.link.block.BlockTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.link.file.FileTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.link.pop_up.PopupTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.link.url.UrlTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.*;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Link extends AbstractToolbarItem {

    Supplier<UrlTab> url;
    Supplier<BlockTab> block;
    Supplier<PopupTab> popUp;
    Supplier<FileTab> file;

    public Link(LinkLocators linkLocators, Frame frame) {
        super(linkLocators.getSelf(), linkLocators.getTabs().getSelf(), frame);
        LinkTabsLocators tabs = linkLocators.getTabs();
        this.url = () -> new UrlTab(tabs.getUrl(), frame);
        this.block = () -> new BlockTab(tabs.getBlock(), frame);
        this.popUp = () -> new PopupTab(tabs.getPopup(), frame);
        this.file = () -> new FileTab(tabs.getFile(), frame);
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        open();
        return Match(tab.toLowerCase()).of(
                Case($(Fields.url), () -> {
                    UrlTab urlTab = url.get();
                    urlTab.open();
                    return urlTab;
                }),
                Case($(Fields.block), () -> {
                    BlockTab blockTab = block.get();
                    blockTab.open();
                    return blockTab;
                }),
                Case($(Fields.popUp), () -> {
                    PopupTab popupTab = popUp.get();
                    popupTab.open();
                    return popupTab;
                }),
                Case($(Fields.file), () -> {
                    FileTab fileTab = file.get();
                    fileTab.open();
                    return fileTab;
                })
        );
    }

    public void applyProperties(LinkProperties propertiesLink) {
        open();
        if (Objects.nonNull(propertiesLink.getUrl())) {
            url.get().applyProperties(propertiesLink.getUrl());
        }
        if (Objects.nonNull(propertiesLink.getBlock())) {
            block.get().applyProperties(propertiesLink.getBlock());
        }
        if (Objects.nonNull(propertiesLink.getPopUp())) {
            popUp.get().applyProperties(propertiesLink.getPopUp());
        }
        if (Objects.nonNull(propertiesLink.getFile())) {
            file.get().applyProperties(propertiesLink.getFile());
        }
    }

    public LinkProperties getProperties() {
        open();
        return LinkProperties.builder()
                .url(url.get().getProperties())
                .block(block.get().getProperties())
                .popUp(popUp.get().getProperties())
                .file(file.get().getFileName())
                .build();
    }

}
