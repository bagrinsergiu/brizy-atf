package com.brizy.io.web.interactions.page.editor.container.components.type.form.toolbar;

import com.brizy.io.web.common.dto.element.properties.form.FormProperties;
import com.brizy.io.web.common.dto.element.properties.form.field.type.FieldsProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.Toolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.item_mover.ItemMover;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type.AbstractField;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.map.colors.Colors;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.map.settings.Settings;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.text.typography.Typography;
import com.microsoft.playwright.Frame;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Objects;
import java.util.function.Supplier;

public abstract class FormToolbar<T extends FieldsProperties> extends Toolbar<FormProperties> {

    Supplier<Button> fieldButton;
    Supplier<Typography> typography;
    Supplier<Colors> colors;
    Supplier<ItemMover> move;
    Supplier<Settings> settings;
    Supplier<Button> duplicate;
    Supplier<Button> delete;

    public FormToolbar(ToolbarLocators toolbar, Frame frame) {
        super(toolbar, frame);
        this.fieldButton = () -> new Button(frame.locator(toolbar.getField().getSelf()));
        this.typography = () -> new Typography(toolbar.getTypography(), frame);
        this.colors = () -> new Colors(toolbar.getColors(), frame);
        this.move = () -> new ItemMover(toolbar.getMover(), frame);
        this.settings = () -> new Settings(toolbar.getSettings(), frame);
        this.duplicate = () -> new Button(frame.locator(toolbar.getDuplicate()));
        this.delete = () -> new Button(frame.locator(toolbar.getDelete()));
    }

    @Override
    public FormProperties getProperties() {
        return null;
    }

    @Override
    public void setProperties(FormProperties properties) {
        if (Objects.nonNull(properties.getField())) {
            fieldButton.get().click();
            getField().applyProperties(properties.getField());
        }
        if (Objects.nonNull(properties.getTypography())) {
            typography.get().applyProperties(properties.getTypography());
        }
    }

    public abstract void setProperties(T properties);

    public abstract AbstractField<T> getField();

    public void moveUp() {
        move.get().moveElementUp();
    }

    public void moveDown() {
        move.get().moveElementDown();
    }

    @Override
    public IsToolbarItem openTabbedPopup(String toolbarItemTitle) {
        throw new NotImplementedException();
    }
}
