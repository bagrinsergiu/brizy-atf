package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.lottie.LottieProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.LottieToolbar;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class Lottie extends Component<LottieProperties> {

    LottieToolbar toolbar;

    public Lottie(ItemLocators itemLocators, Frame frame, Locator locator) {
        super(frame, locator, itemLocators);
        this.toolbar = new LottieToolbar(itemLocators.getToolbar(), frame);
    }

    @Override
    public LottieProperties getEditorProperties() {
        return toolbar.getProperties();
    }

}
