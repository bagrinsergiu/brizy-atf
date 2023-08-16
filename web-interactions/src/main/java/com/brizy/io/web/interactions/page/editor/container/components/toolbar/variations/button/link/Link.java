package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.link;

import com.brizy.io.web.common.dto.element.properties.button.link.LinkProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.IsTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.HasTabs;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.link.block.BlockTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.link.file.FileTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.link.pop_up.PopupTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.link.url.UrlTab;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.link.LinkLocators;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.link.tabs.LinkTabsLocators;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.*;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Link implements HasTabs {

    @Getter
    Supplier<Locator> tabsLocator;
    Supplier<Button> linkButton;
    Supplier<UrlTab> url;
    Supplier<BlockTab> block;
    Supplier<PopupTab> popUp;
    Supplier<FileTab> file;

    public Link(LinkLocators linkLocators, Frame frame) {
        LinkTabsLocators tabs = linkLocators.getTabs();
        this.linkButton = () -> new Button(frame.locator(linkLocators.getSelf()));
        this.tabsLocator = () -> frame.locator(tabs.getSelf());
        this.url = () -> new UrlTab(tabs.getUrl(), frame);
        this.block = () -> new BlockTab(tabs.getBlock(), frame);
        this.popUp = () -> new PopupTab(tabs.getPopup(), frame);
        this.file = () -> new FileTab(tabs.getFile(), frame);
    }

    @Override
    public IsTab openTab(String tab) {
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
        linkButton.get().click();
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
        linkButton.get().click();
        return LinkProperties.builder()
                .url(url.get().getProperties())
                .block(block.get().getProperties())
                .popUp(popUp.get().getProperties())
                .file(file.get().getFileName())
                .build();
    }
}
