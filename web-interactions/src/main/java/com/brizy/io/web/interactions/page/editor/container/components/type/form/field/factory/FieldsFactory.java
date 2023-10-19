package com.brizy.io.web.interactions.page.editor.container.components.type.form.field.factory;

import com.brizy.io.web.common.dto.element.properties.form.FormProperties;
import com.brizy.io.web.common.dto.element.properties.form.field.type.FieldsProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.type.Number;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.type.*;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import io.vavr.API;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FieldsFactory {

    public FormField getField(ItemLocators fieldLocators, FormProperties formProperties, FieldsProperties fieldProperties, Frame frame, Locator elementLocator) {
        return API.Match(fieldProperties.getType().toLowerCase()).of(
                API.Case(API.$("text"), () -> new Text(fieldLocators, formProperties, frame, elementLocator)),
                API.Case(API.$("email"), () -> new Email(fieldLocators, formProperties, frame, elementLocator)),
                API.Case(API.$("number"), () -> new Number(fieldLocators, formProperties, frame, elementLocator)),
                API.Case(API.$("paragraph"), () -> new Paragraph(fieldLocators, formProperties, frame, elementLocator)),
                API.Case(API.$("select"), () -> new Select(fieldLocators, formProperties, frame, elementLocator)),
                API.Case(API.$("radio"), () -> new Radio(fieldLocators, formProperties, frame, elementLocator)),
                API.Case(API.$("checkbox"), () -> new CheckBox(fieldLocators, formProperties, frame, elementLocator)),
                API.Case(API.$("date"), () -> new Date(fieldLocators, formProperties, frame, elementLocator)),
                API.Case(API.$("url"), () -> new Url(fieldLocators, formProperties, frame, elementLocator)),
                API.Case(API.$("time"), () -> new Time(fieldLocators, formProperties, frame, elementLocator)),
                API.Case(API.$("fileupload"), () -> new File(fieldLocators, formProperties, frame, elementLocator)),
                API.Case(API.$("hidden"), () -> new Hidden(fieldLocators, formProperties, frame, elementLocator)),
                API.Case(API.$("tel"), () -> new Tel(fieldLocators, formProperties, frame, elementLocator)),
                API.Case(API.$("password"), () -> new Password(fieldLocators, formProperties, frame, elementLocator))
        );
    }

}
