package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field;

import com.brizy.io.web.interactions.locators.AbstractProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.InputWithUnitsLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.check_box.CheckboxFieldLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.radio.RadioFieldLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.select.SelectFieldLocators;
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
public class FieldLocator extends AbstractProperty {

    String configurations;
    String type;
    String required;
    String multipleSelection;
    String nativeHtml5;
    String minNumberErrorMessage;
    String maxNumberErrorMessage;
    String min;
    String max;
    String minDate;
    String maxDate;
    String minTime;
    String maxTime;
    String columns;
    String fileSizeErrorMessage;
    String fileTypeErrorMessage;
    String maxFileSize;
    String allowedFileTypes;
    @NestedConfigurationProperty
    InputWithUnitsLocators spacing;
    @NestedConfigurationProperty
    CheckboxFieldLocators checkBox;
    @NestedConfigurationProperty
    SelectFieldLocators select;
    @NestedConfigurationProperty
    RadioFieldLocators radio;

}
