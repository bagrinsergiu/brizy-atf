package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.carousel.CarouselProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.CarouselToolbar;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class Carousel extends Component<CarouselProperties> {

    CarouselToolbar toolbar;
    Supplier<Button> borderButton;

    public Carousel(ItemLocators itemLocators, Frame frame, Locator locator) {
        super(frame, locator, itemLocators);
        this.toolbar = new CarouselToolbar(itemLocators.getToolbar(), frame);
        this.borderButton = () -> new Button(getBorderButton(frame.locator(itemLocators.getBorderButton())));
    }

    private Locator getBorderButton(Locator locator) {
        var count = locator.count();
        return locator.all().get(count - 1);
    }

    @Override
    public CarouselProperties getEditorProperties() {
        return toolbar.getProperties();
    }

    @Override
    protected void openToolbar() {
        borderButton.get().click();
    }

}
