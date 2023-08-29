package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.link.url;

import com.brizy.io.web.common.dto.element.properties.button.link.url.URL;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.element.composite.InputWithPopulation;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.link.tabs.url.UrlTabLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UrlTab extends AbstractTabItem {

    Supplier<InputWithPopulation> linkTo;
    Supplier<Slider> openInNewTab;
    Supplier<Slider> makeItNoFollow;

    public UrlTab(UrlTabLocators urlTabLocators, Frame frame) {
        super(urlTabLocators.getConfigurations(), urlTabLocators.getSelf(), frame);
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

    public URL getProperties() {
        open();
        return URL.builder()
                .linkTo(linkTo.get().getValue())
                .openInNewTab(openInNewTab.get().getState())
                .makeItNoFollow(makeItNoFollow.get().getState())
                .build();
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.linkTo).element(linkTo).build(),
                Configuration.builder().name(Fields.makeItNoFollow).element(makeItNoFollow).build(),
                Configuration.builder().name(Fields.openInNewTab).element(openInNewTab).build()
        );
    }

}
