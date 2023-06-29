package com.brizy.io.web.interactions.components.factory;

import com.brizy.io.web.interactions.components.editor.container.components.Button;
import com.brizy.io.web.interactions.components.editor.container.components.Component;
import com.brizy.io.web.interactions.components.editor.container.components.Map;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.ItemProperties;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import io.vavr.API;
import lombok.experimental.UtilityClass;

import static com.brizy.io.web.interactions.components.factory.enums.ComponentClassNames.BUTTON;
import static com.brizy.io.web.interactions.components.factory.enums.ComponentClassNames.MAP;

@UtilityClass
public class ComponentsFactory {

    public <T extends Component> T getElementByType(Locator locator, Frame frame, ItemProperties itemProperties) {
        return (T) API.Match(locator.getAttribute("class")).of(
                API.Case(API.$(classAttribute -> classAttribute.contains(MAP.getValue())), () -> new Map(itemProperties, frame, locator)),
                API.Case(API.$(classAttribute -> classAttribute.contains(BUTTON.getValue())), () -> new Button(itemProperties, frame, locator))
        );
    }

}
