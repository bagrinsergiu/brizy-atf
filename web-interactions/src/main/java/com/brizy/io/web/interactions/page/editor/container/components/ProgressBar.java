package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.progress_bar.ProgressBarProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.ProgressBarToolbar;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class ProgressBar extends Component<ProgressBarProperties> {

    ProgressBarToolbar toolbar;

    public ProgressBar(ItemLocators itemLocators, Frame frame, Locator locator) {
        super(frame, locator, itemLocators);
        this.toolbar = new ProgressBarToolbar(itemLocators.getToolbar(), frame);
    }

    @Override
    public ProgressBarProperties getEditorProperties() {
        return toolbar.getProperties();
    }

}
