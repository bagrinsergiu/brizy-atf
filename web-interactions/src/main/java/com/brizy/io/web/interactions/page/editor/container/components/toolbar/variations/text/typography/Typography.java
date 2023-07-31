package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.text.typography;

import com.brizy.io.web.common.dto.element.properties.toolbar.text.typography.size.Size;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.typography.SizeDto;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.typography.TypographyDto;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.composite.ControlInput;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.text.typography.font.FontsMenu;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.text.typography.size.SizeInput;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.typography.TypographyProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Typography {

    Supplier<FontsMenu> fontsMenu;
    Supplier<SizeInput> size;
    Supplier<ComboBox> typography;
    Supplier<ControlInput> lineHgt;
    Supplier<ControlInput> letterSp;
    Supplier<ComboBox> weight;

    public Typography(TypographyProperties properties, Frame frame) {
        this.fontsMenu = () -> new FontsMenu(properties.getFonts(), frame);
        this.size = () -> new SizeInput(properties.getStyles().getSize(), frame);
        this.lineHgt = () -> new ControlInput(properties.getStyles().getLineHgt().getValue(), frame);
        this.letterSp = () -> new ControlInput(properties.getStyles().getLetterSp().getValue(), frame);
        this.typography = () -> new ComboBox(frame.locator(properties.getStyles().getTypography().getSelf()));
        this.weight = () -> new ComboBox(frame.locator(properties.getStyles().getWeight().getValue()));
    }

    public void applyProperties(com.brizy.io.web.common.dto.element.properties.toolbar.text.typography.Typography properties) {
        fontsMenu.get().selectFont(properties.getFont());
        size.get().setValue(properties.getSize());
        letterSp.get().fill(properties.getLetterSp());
        lineHgt.get().fillWithControls(properties.getLineHgt());
        weight.get().selectItem(properties.getWeight());
        typography.get().selectItem(properties.getTypography());
    }

    public TypographyDto getProperties() {
        Size sizeValue = size.get().getValue();
        return TypographyDto.builder()
                .activeFont(fontsMenu.get().getActiveFont())
                .typography(typography.get().getSelectedItem())
                .size(SizeDto.builder()
                        .size(sizeValue.getValue())
                        .unit(sizeValue.getUnit())
                        .build())
                .weight(weight.get().getSelectedItem())
                .lineHgt(lineHgt.get().value())
                .letterSp(letterSp.get().value())
                .build();
    }

}
