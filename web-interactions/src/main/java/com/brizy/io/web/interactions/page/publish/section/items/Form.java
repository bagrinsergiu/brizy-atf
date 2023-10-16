package com.brizy.io.web.interactions.page.publish.section.items;

import com.brizy.io.web.interactions.locators.publish.section.container.item.form.FormFieldLocators;
import com.brizy.io.web.interactions.page.common.GenericComponent;
import com.brizy.io.web.interactions.page.publish.section.items.form.item.Select;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Form extends GenericComponent {
    String placeholderAttribute = "data-brz-placeholder";

    Map<String, Select> selects;

    public Form(FormFieldLocators form, Locator locator) {
        this.selects = initSelects(form.getSelect(), locator);
    }

    private Map<String, Select> initSelects(String selectLocator, Locator locator) {
        return locator.locator(selectLocator).all().stream()
                .map(foundLocator -> Pair.of(foundLocator.getAttribute(placeholderAttribute), new Select(foundLocator)))
                .collect(HashMap::new, (map, k) -> map.put(k.getKey(), k.getValue()), HashMap::putAll);
    }

    public Select findSelectItemByPlaceholder(String placeholder) {
        return selects.get(placeholder);
    }

}
