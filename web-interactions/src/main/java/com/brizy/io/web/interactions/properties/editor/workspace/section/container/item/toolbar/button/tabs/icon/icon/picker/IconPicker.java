package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.button.tabs.icon.icon.picker;

import com.brizy.io.web.interactions.properties.AbstractProperty;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.button.tabs.icon.icon.picker.pop_up.IconPickerPopupLocators;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class IconPicker extends AbstractProperty {

    @NestedConfigurationProperty
    IconPickerPopupLocators popUp;

}
