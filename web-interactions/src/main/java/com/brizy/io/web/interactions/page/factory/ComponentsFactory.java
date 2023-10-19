package com.brizy.io.web.interactions.page.factory;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.locators.publish.section.container.item.PublishedItemLocators;
import com.brizy.io.web.interactions.page.common.GenericComponent;
import com.brizy.io.web.interactions.page.editor.container.components.*;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.Form;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import io.vavr.API;
import lombok.experimental.UtilityClass;

import static com.brizy.io.web.interactions.page.factory.enums.ComponentClassNames.*;

@SuppressWarnings("all")
@UtilityClass
public class ComponentsFactory {

    public <T extends Component> T getComponentByType(Locator locator, Frame frame, ItemLocators itemLocators) {
        return (T) API.Match(locator.getAttribute("class")).of(
                API.Case(API.$(classAttribute -> classAttribute.contains(MAP.getValue())), () -> new Map(itemLocators, frame, locator)),
                API.Case(API.$(classAttribute -> classAttribute.contains(FORM.getValue())), () -> new Form(itemLocators, frame, locator)),
                API.Case(API.$(classAttribute -> classAttribute.contains(TEXT.getValue())), () -> new Text(itemLocators, frame, locator)),
                API.Case(API.$(classAttribute -> classAttribute.contains(COUNTER.getValue())), () -> new Counter(itemLocators, frame, locator)),
                API.Case(API.$(classAttribute -> classAttribute.contains(IMAGE.getValue())), () -> new Image(itemLocators, frame, locator)),
                API.Case(API.$(classAttribute -> classAttribute.contains(SPACER.getValue())), () -> new Spacer(itemLocators, frame, locator)),
                API.Case(API.$(classAttribute -> classAttribute.contains("brz-d-xs-flex")), () -> {
                    String innerHtml = locator.innerHTML();
                    return API.Match(innerHtml).of(
                            API.Case(API.$(inner -> inner.contains(ICON.getValue())), () -> new Icon(itemLocators, frame, locator)),
                            API.Case(API.$(inner -> inner.contains(BUTTON.getValue())), () -> new Button(itemLocators, frame, locator))
                    );
                })
        );
    }

    public <T extends GenericComponent> T getComponentByType(Locator locator, PublishedItemLocators publishedItemLocators) {
        return (T) API.Match(locator.getAttribute("class")).of(
                API.Case(API.$(classAttribute -> classAttribute.contains(MAP.getValue())), () -> new com.brizy.io.web.interactions.page.publish.section.items.Map(locator)),
                API.Case(API.$(classAttribute -> classAttribute.contains(BUTTON.getValue())), () -> new com.brizy.io.web.interactions.page.publish.section.items.Button(locator)),
                API.Case(API.$(), () -> {
                    var formFilter = locator.locator(publishedItemLocators.getForm().getSelf());
                    if (formFilter.count() > 0) {
                        return new com.brizy.io.web.interactions.page.publish.section.items.Form(publishedItemLocators.getForm().getField(), locator.locator(publishedItemLocators.getForm().getSelf()));
                    }
                    return null;
                })
        );
    }

}