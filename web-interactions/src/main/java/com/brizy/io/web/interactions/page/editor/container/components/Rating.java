package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.rating.RatingProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.RatingToolbar;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class Rating extends Component<RatingProperties> {

    RatingToolbar toolbar;

    public Rating(ItemLocators itemLocators, Frame frame, Locator locator) {
        super(frame, locator, itemLocators);
        this.toolbar = new RatingToolbar(itemLocators.getToolbar(), frame);
    }

    @Override
    public RatingProperties getEditorProperties() {
        return toolbar.getProperties();
    }

}
