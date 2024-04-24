package com.brizy.io.web.interactions.page.factory;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.locators.publish.section.container.item.PublishedItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.*;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.Form;
import com.brizy.io.web.interactions.page.publish.common.PublishedComponent;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import io.vavr.API;
import lombok.experimental.UtilityClass;

import static com.brizy.io.web.interactions.page.factory.enums.ComponentClassNames.*;
import static io.vavr.API.$;
import static io.vavr.API.Case;

@SuppressWarnings("all")
@UtilityClass
public class ComponentsFactory {

    public <T extends Component> T getComponentByType(Locator locator, Frame frame, ItemLocators itemLocators) {
        return (T) API.Match(locator.getAttribute("class")).of(
                Case($(classAttribute -> classAttribute.contains(ALERT.getValue())), () -> new Alert(itemLocators, frame, locator)),
                Case($(classAttribute -> classAttribute.contains(AUDIO.getValue())), () -> new Audio(itemLocators, frame, locator)),
                Case($(classAttribute -> classAttribute.contains(CALENDLY.getValue())), () -> new Calendly(itemLocators, frame, locator)),
                Case($(classAttribute -> classAttribute.contains(CAROUSEL.getValue())), () -> new Carousel(itemLocators, frame, locator)),
                Case($(classAttribute -> classAttribute.contains(COUNTDOWN.getValue())), () -> new Countdown(itemLocators, frame, locator)),
                Case($(classAttribute -> classAttribute.contains(COUNTER.getValue())), () -> new Counter(itemLocators, frame, locator)),
                Case($(classAttribute -> classAttribute.contains(FORM.getValue())), () -> new Form(itemLocators, frame, locator)),
                Case($(classAttribute -> classAttribute.contains(GALLERY.getValue())), () -> new Gallery(itemLocators, frame, locator)),
                Case($(classAttribute -> classAttribute.contains(IMAGE.getValue())), () -> new Image(itemLocators, frame, locator)),
                Case($(classAttribute -> classAttribute.contains(LINE.getValue())), () -> new Line(itemLocators, frame, locator)),
                Case($(classAttribute -> classAttribute.contains(LOTTIE.getValue())), () -> new Lottie(itemLocators, frame, locator)),
                Case($(classAttribute -> classAttribute.contains(MAP.getValue())), () -> new Map(itemLocators, frame, locator)),
                Case($(classAttribute -> classAttribute.contains(PLAYLIST.getValue())), () -> new Playlist(itemLocators, frame, locator)),
                Case($(classAttribute -> classAttribute.contains(PROGRESS_BAR.getValue())), () -> new ProgressBar(itemLocators, frame, locator)),
                Case($(classAttribute -> classAttribute.contains(RATING.getValue())), () -> new Rating(itemLocators, frame, locator)),
                Case($(classAttribute -> classAttribute.contains(SPACER.getValue())), () -> new Spacer(itemLocators, frame, locator)),
                Case($(classAttribute -> classAttribute.contains(TEXT.getValue())), () -> new Text(itemLocators, frame, locator)),
                Case($(classAttribute -> classAttribute.contains(VIDEO.getValue())), () -> new Video(itemLocators, frame, locator)),
                Case($(classAttribute -> classAttribute.contains("brz-d-xs-flex")), () -> {
                    String innerHtml = locator.innerHTML();
                    return API.Match(innerHtml).of(
                            Case($(inner -> inner.contains(ICON.getValue())), () -> new Icon(itemLocators, frame, locator)),
                            Case($(inner -> inner.contains(BUTTON.getValue())), () -> new Button(itemLocators, frame, locator))
                    );
                })
        );
    }

    public <T extends PublishedComponent> T getComponentByType(Locator locator, PublishedItemLocators publishedItemLocators) {
        return (T) API.Match(locator.getAttribute("class")).of(
//                Case($(classAttribute -> classAttribute.contains(MAP.getValue())), () -> new com.brizy.io.web.interactions.page.publish.section.items.Map(locator)),
//                Case($(classAttribute -> classAttribute.contains(BUTTON.getValue())), () -> new com.brizy.io.web.interactions.page.publish.section.items.Button(locator)),
//                Case($(classAttribute -> classAttribute.contains(TEXT.getValue())), () -> new com.brizy.io.web.interactions.page.publish.section.items.Text(locator)),
//                Case($(classAttribute -> classAttribute.contains(GALLERY.getValue())), () -> new com.brizy.io.web.interactions.page.publish.section.items.Gallery(locator)),
//                Case($(classAttribute -> classAttribute.contains(IMAGE.getValue())), () -> new com.brizy.io.web.interactions.page.publish.section.items.Image(locator)),
                Case($(), () -> {
                    if (locator.locator(publishedItemLocators.getForm().getSelf()).count() > 0) {
                        return new com.brizy.io.web.interactions.page.publish.section.items.Form(publishedItemLocators.getForm().getField(), locator.locator(publishedItemLocators.getForm().getSelf()));
                    }
                    if (locator.locator(publishedItemLocators.getGallery().getSelf()).count() > 0) {
                        return new com.brizy.io.web.interactions.page.publish.section.items.Gallery(locator.locator(publishedItemLocators.getGallery().getSelf()));
                    }
                    return null;
                })
        );
    }

}