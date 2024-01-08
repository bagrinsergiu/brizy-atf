package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.lottie;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.lottie.LottieLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.lottie.tabs.LottieTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.$;
import static io.vavr.API.Case;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Lottie extends AbstractToolbarItem {

    Supplier<LottieTab> lottie;

    public Lottie(LottieLocators lottieLocators, Frame frame) {
        super(lottieLocators.getSelf(), lottieLocators.getTabs().getSelf(), frame);
        this.lottie = () -> new LottieTab(lottieLocators.getTabs().getLottie(), frame);
    }

    public void applyProperties(com.brizy.io.web.common.dto.element.properties.lottie.lottie.Lottie lottie) {
        if (Objects.nonNull(lottie.getLottie())) {
            this.lottie.get().applyProperties(lottie.getLottie());
        }
    }

    public com.brizy.io.web.common.dto.element.properties.lottie.lottie.Lottie getProperties() {
        return com.brizy.io.web.common.dto.element.properties.lottie.lottie.Lottie.builder()
                .lottie(lottie.get().getProperties())
                .build();
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        open();
        return io.vavr.API.Match(tab.toLowerCase()).of(
                Case($(), lottie)
        );
    }
}
