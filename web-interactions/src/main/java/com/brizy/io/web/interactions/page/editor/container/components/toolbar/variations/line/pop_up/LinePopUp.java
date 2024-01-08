package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.line.pop_up;

import com.brizy.io.web.common.dto.element.properties.line.pop_up.LinePopUpProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.line.LineLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.line.pop_up.tabs.icon.LineIconTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.line.pop_up.tabs.line.LineTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.line.pop_up.tabs.text.TextTab;
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
public class LinePopUp extends AbstractToolbarItem {

    Supplier<LineIconTab> icon;
    Supplier<TextTab> text;
    Supplier<LineTab> line;

    public LinePopUp(LineLocators lineLocators, Frame frame) {
        super(lineLocators.getSelf(), lineLocators.getTabs().getSelf(), frame);
        var lineTabsLocators = lineLocators.getTabs();
        this.icon = () -> new LineIconTab(lineTabsLocators.getIcon(), frame);
        this.text = () -> new TextTab(lineTabsLocators.getText(), frame);
        this.line = () -> new LineTab(lineTabsLocators.getLine(), frame);
    }

    public void applyProperties(LinePopUpProperties lineProperties) {
        open();
        if (Objects.nonNull(lineProperties.getLine())) {
            line.get().applyProperties(lineProperties.getLine());
        }
        if (Objects.nonNull(lineProperties.getText())) {
            text.get().applyProperties(lineProperties.getText());
        }
        if (Objects.nonNull(lineProperties.getIcon())) {
            icon.get().applyProperties(lineProperties.getIcon());
        }
    }

    public LinePopUpProperties getProperties() {
        open();
        return LinePopUpProperties.builder()
                .line(line.get().getProperties())
                .icon(icon.get().isDisplayed() ? icon.get().getProperties() : null)
                .text(text.get().isDisplayed() ? text.get().getProperties() : null)
                .build();
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        open();
        return io.vavr.API.Match(tab.toLowerCase()).of(
                Case($(Fields.icon), icon),
                Case($(Fields.text), text),
                Case($(), line)
        );
    }
}
