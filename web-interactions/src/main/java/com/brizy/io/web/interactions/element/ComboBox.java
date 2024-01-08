package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ComboBox extends AbstractElement {

    public ComboBox(Locator locator) {
        super(locator);
    }

    private void open() {
        locator.click();
    }

    public void selectItemByName(String itemName) {
        open();
        Locator byText = locator.getByRole(AriaRole.OPTION, new Locator.GetByRoleOptions().setName(itemName).setExact(true));
        byText.scrollIntoViewIfNeeded();
        byText.click();
    }

    public void selectItemByValue(String value) {
        open();
        Locator byText = locator.getByRole(AriaRole.OPTION).all()
                .stream()
                .filter(locator -> locator.getAttribute("value").equalsIgnoreCase(value))
                .findFirst()
                .orElse(locator);
        byText.scrollIntoViewIfNeeded();
        byText.click();
    }

    public List<String> items(Predicate<Locator> filterToApply, Function<Locator, String> mappingFunction) {
        open();
        return locator.getByRole(AriaRole.OPTION).all()
                .stream()
                .filter(filterToApply)
                .map(mappingFunction)
                .collect(Collectors.toList());
    }

    public String getSelectedItem() {
        if (!isVisible()) {
            return null;
        }
        return locator.textContent();
    }

    public String getValueForSelectedItem() {
        if (!isVisible()) {
            return null;
        }
        return locator.getAttribute("value");
    }

    public String getInnerHtmlSelectedValue() {
        if (!isVisible()) {
            return null;
        }
        String value = locator.locator("//div[contains(@class,'multiSelect--tag--value')]").innerHTML().replaceAll(".*-", "").replaceAll("\".*", "");
        return value.substring(0, 1).toUpperCase().concat(value.substring(1));
    }

}
