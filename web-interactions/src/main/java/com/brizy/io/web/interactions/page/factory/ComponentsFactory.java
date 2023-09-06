package com.brizy.io.web.interactions.page.factory;

import com.brizy.io.web.interactions.page.common.GenericComponent;
import com.brizy.io.web.interactions.page.editor.container.components.*;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemProperties;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import io.vavr.API;
import io.vavr.control.Try;
import lombok.experimental.UtilityClass;

import static com.brizy.io.web.interactions.page.factory.enums.ComponentClassNames.*;

@SuppressWarnings("all")
@UtilityClass
public class ComponentsFactory {

    public <T extends Component> T getComponentByType(Locator locator, Frame frame, ItemProperties itemProperties) {
        return (T) API.Match(locator.getAttribute("class")).of(
                API.Case(API.$(classAttribute -> classAttribute.contains(MAP.getValue())), () -> new Map(itemProperties, frame, locator)),
                API.Case(API.$(classAttribute -> classAttribute.contains(TEXT.getValue())), () -> new Text(itemProperties, frame, locator)),
                API.Case(API.$(classAttribute -> classAttribute.contains(COUNTER.getValue())), () -> new Counter(itemProperties, frame, locator)),
                API.Case(API.$(classAttribute -> classAttribute.contains(IMAGE.getValue())), () -> new Image(itemProperties, frame, locator)),
                API.Case(API.$(classAttribute -> classAttribute.contains("brz-d-xs-flex")), () -> {
                    String innerHtml = locator.innerHTML();
                    return API.Match(innerHtml).of(
                            API.Case(API.$(inner -> inner.contains(ICON.getValue())), () -> new Icon(itemProperties, frame, locator)),
                            API.Case(API.$(inner -> inner.contains(BUTTON.getValue())), () -> new Button(itemProperties, frame, locator))
                    );
                })
        );
    }

    public <T extends GenericComponent> T getComponentByType(Locator locator) {
        return (T) API.Match(locator.getAttribute("class")).of(
                API.Case(API.$(classAttribute -> classAttribute.contains(MAP.getValue())), () -> new com.brizy.io.web.interactions.page.publish.Map(locator)),
                API.Case(API.$(classAttribute -> classAttribute.contains(BUTTON.getValue())), () -> new com.brizy.io.web.interactions.page.publish.Button(locator))
        );
    }

}
