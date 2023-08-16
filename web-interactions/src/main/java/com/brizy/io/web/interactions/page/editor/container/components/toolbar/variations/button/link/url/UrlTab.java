package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.link.url;

import com.brizy.io.web.common.dto.element.properties.button.link.url.URL;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.element.composite.InputWithPopulation;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.IsTab;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.link.tabs.url.UrlTabLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UrlTab implements IsTab {

    @Getter
    Supplier<Button> tabButton;
    Supplier<InputWithPopulation> linkTo;
    Supplier<Slider> openInNewTab;
    Supplier<Slider> makeItNoFollow;

    public UrlTab(UrlTabLocators urlTabLocators, Frame frame) {
        this.tabButton = () -> new Button(frame.locator(urlTabLocators.getSelf()));
        this.linkTo = () -> new InputWithPopulation(urlTabLocators.getLinkTo(), frame);
        this.openInNewTab = () -> new Slider(frame.locator(urlTabLocators.getOpenInNewTab()));
        this.makeItNoFollow = () -> new Slider(frame.locator(urlTabLocators.getMakeItNoFollow()));
    }

    public void applyProperties(URL url) {
        open();
        if (Objects.nonNull(url.getLinkTo())) {
            linkTo.get().setValue(url.getLinkTo());
        }
        if (Objects.nonNull(url.getOpenInNewTab())) {
            openInNewTab.get().switchTo(url.getOpenInNewTab());
        }
        if (Objects.nonNull(url.getMakeItNoFollow())) {
            makeItNoFollow.get().switchTo(url.getMakeItNoFollow());
        }
    }

    @Override
    public List<String> getWebConfigurations() {
        return null;
    }

    @Override
    public List<Configuration> getConfigurations() {
        return null;
    }

    public URL getProperties() {
        open();
        return URL.builder()
                .linkTo(linkTo.get().getValue())
                .openInNewTab(openInNewTab.get().getState())
                .makeItNoFollow(makeItNoFollow.get().getState())
                .build();
    }
}
