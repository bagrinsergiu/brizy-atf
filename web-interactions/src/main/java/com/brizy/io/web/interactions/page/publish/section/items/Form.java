package com.brizy.io.web.interactions.page.publish.section.items;

import com.brizy.io.web.interactions.locators.publish.section.container.item.form.FormCheckBoxItemLocators;
import com.brizy.io.web.interactions.locators.publish.section.container.item.form.FormFieldLocators;
import com.brizy.io.web.interactions.locators.publish.section.container.item.form.FormRadioItemLocators;
import com.brizy.io.web.interactions.page.common.GenericComponent;
import com.brizy.io.web.interactions.page.publish.section.items.form.item.Number;
import com.brizy.io.web.interactions.page.publish.section.items.form.item.Text;
import com.brizy.io.web.interactions.page.publish.section.items.form.item.*;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Form extends GenericComponent {

    String placeholderAttribute = "data-brz-placeholder";

    Supplier<Map<String, FormItem>> items;

    public Form(FormFieldLocators form, Locator locator) {
        this.items = () -> new HashMap<>() {{
            putAll(initRadios(form.getRadio(), locator));
            putAll(initCheckboxes(form.getCheckBox(), locator));
            putAll(initSelects(form.getSelect(), locator));
            putAll(initTexts(form.getText(), locator));
            putAll(initEmails(form.getEmail(), locator));
            putAll(initNumbers(form.getNumber(), locator));
            putAll(initDate(form.getDate(), locator));
        }};
    }

    private Map<String, FormItem> initNumbers(String numberLocator, Locator locator) {
        return locator.locator(numberLocator).all().stream()
                .map(foundLocator -> Pair.of(foundLocator.getAttribute(placeholderAttribute), new Number(foundLocator)))
                .collect(HashMap::new, (map, k) -> map.put(k.getKey(), k.getValue()), HashMap::putAll);
    }

    private Map<String, FormItem> initDate(String dateLocators, Locator locator) {
        return locator.locator(dateLocators).all().stream()
                .map(foundLocator -> Pair.of(foundLocator.getAttribute(placeholderAttribute), new Date(foundLocator)))
                .collect(HashMap::new, (map, k) -> map.put(k.getKey(), k.getValue()), HashMap::putAll);
    }

    private Map<String, FormItem> initEmails(String emailLocator, Locator locator) {
        return locator.locator(emailLocator).all().stream()
                .map(foundLocator -> Pair.of(foundLocator.getAttribute(placeholderAttribute), new Email(foundLocator)))
                .collect(HashMap::new, (map, k) -> map.put(k.getKey(), k.getValue()), HashMap::putAll);
    }

    private Map<String, FormItem> initTexts(String textLocator, Locator locator) {
        return locator.locator(textLocator).all().stream()
                .map(foundLocator -> Pair.of(foundLocator.getAttribute(placeholderAttribute), new Text(foundLocator)))
                .collect(HashMap::new, (map, k) -> map.put(k.getKey(), k.getValue()), HashMap::putAll);
    }

    private Map<String, FormItem> initCheckboxes(FormCheckBoxItemLocators checkBoxLocators, Locator locator) {
        return locator.locator(checkBoxLocators.getSelf()).all().stream()
                .map(foundLocator -> Pair.of(foundLocator.getAttribute(placeholderAttribute), new CheckBox(checkBoxLocators, foundLocator)))
                .collect(HashMap::new, (map, k) -> map.put(k.getKey(), k.getValue()), HashMap::putAll);
    }

    private Map<String, FormItem> initRadios(FormRadioItemLocators radioLocator, Locator locator) {
        return locator.locator(radioLocator.getSelf()).all().stream()
                .map(foundLocator -> Pair.of(foundLocator.getAttribute(placeholderAttribute), new Radio(radioLocator, foundLocator)))
                .collect(HashMap::new, (map, k) -> map.put(k.getKey(), k.getValue()), HashMap::putAll);
    }

    private Map<String, FormItem> initSelects(String selectLocator, Locator locator) {
        return locator.locator(selectLocator).all().stream()
                .map(foundLocator -> Pair.of(foundLocator.getAttribute(placeholderAttribute), new Select(foundLocator)))
                .collect(HashMap::new, (map, k) -> map.put(k.getKey(), k.getValue()), HashMap::putAll);
    }

    public <T extends FormItem> T findSelectItemByPlaceholder(Class<?> clazz, String placeholder) {
        placeholder = List.of("RadioField", "CheckboxField").contains(placeholder) ? null : placeholder;
        return (T) clazz.cast(items.get().get(placeholder));
    }

}
