package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.text.typography;

import com.brizy.io.web.common.dto.element.properties.common.typography.size.Size;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.composite.ControlInput;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.typography.TypographyProperties;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.text.typography.font.FontsMenu;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.text.typography.size.SizeInput;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Typography extends AbstractToolbarItem {

    Supplier<Button> typographyButton;
    Supplier<FontsMenu> fontsMenu;
    Supplier<SizeInput> size;
    Supplier<ComboBox> typography;
    Supplier<ControlInput> lineHgt;
    Supplier<ControlInput> letterSp;
    Supplier<ComboBox> weight;

    public Typography(TypographyProperties properties, Frame frame) {
        super(properties.getSelf(), properties.getSelf(), frame);
        this.typographyButton = () -> new Button(frame.locator(properties.getSelf()));
        this.fontsMenu = () -> new FontsMenu(properties.getFonts(), frame);
        this.size = () -> new SizeInput(properties.getStyles().getSize(), frame);
        this.lineHgt = () -> new ControlInput(properties.getStyles().getLineHgt().getValue(), frame);
        this.letterSp = () -> new ControlInput(properties.getStyles().getLetterSp().getValue(), frame);
        this.typography = () -> new ComboBox(frame.locator(properties.getStyles().getTypography().getSelf()));
        this.weight = () -> new ComboBox(frame.locator(properties.getStyles().getWeight().getValue()));
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        return null;
    }

    public void applyProperties(com.brizy.io.web.common.dto.element.properties.common.typography.Typography properties) {
        typographyButton.get().click();
        if (Objects.nonNull(properties.getFont())) {
            fontsMenu.get().selectFont(properties.getFont());
        }
        if (Objects.nonNull(properties.getSize())) {
            size.get().setValue(properties.getSize());
        }
        if (Objects.nonNull(properties.getLetterSp())) {
            letterSp.get().fill(properties.getLetterSp());
        }
        if (Objects.nonNull(properties.getLineHgt())) {
            lineHgt.get().fillWithControls(properties.getLineHgt());
        }
        if (Objects.nonNull(properties.getWeight())) {
            weight.get().selectItemByName(properties.getWeight());
        }
        if (Objects.nonNull(properties.getTypography())) {
            typography.get().selectItemByName(properties.getTypography());
        }
    }

    public com.brizy.io.web.common.dto.element.properties.common.typography.Typography getProperties() {
        typographyButton.get().click();
        Size sizeValue = size.get().getValue();
        return com.brizy.io.web.common.dto.element.properties.common.typography.Typography.builder()
                .font(fontsMenu.get().getActiveFont())
                .typography(typography.get().getSelectedItem())
                .size(Size.builder().unit(sizeValue.getUnit()).value(sizeValue.getValue()).build())
                .weight(weight.get().getSelectedItem())
                .lineHgt(lineHgt.get().value())
                .letterSp(letterSp.get().value())
                .build();
    }

}
