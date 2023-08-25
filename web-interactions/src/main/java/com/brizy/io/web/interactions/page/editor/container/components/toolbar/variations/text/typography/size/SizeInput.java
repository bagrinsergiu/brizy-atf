package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.text.typography.size;

import com.brizy.io.web.common.dto.element.properties.common.typography.size.Size;
import com.brizy.io.web.common.dto.element.properties.common.typography.size.Units;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.composite.ControlInput;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.typography.styles.size.SizeProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SizeInput {

    Supplier<ControlInput> size;
    Supplier<ComboBox> type;

    public SizeInput(SizeProperties properties, Frame frame) {
        this.size = () -> new ControlInput(properties.getValue(), frame);
        this.type = () -> new ComboBox(frame.locator(properties.getUnit().getSelf()));
    }

    public void setValue(Size size) {
        this.size.get().fill(Double.valueOf(size.getValue()));
        this.type.get().selectItemByName(size.getUnit().name());
    }

    public Size getValue() {
        return new Size(size.get().value().intValue(), Units.valueOf(type.get().getSelectedItem()));
    }

}
