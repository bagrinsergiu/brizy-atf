package com.brizy.io.web.interactions.page.common;

import com.brizy.io.web.interactions.dto.editor.container.ComponentDimensionsDto;
import com.brizy.io.web.interactions.dto.editor.container.ElementPositionDto;
import com.brizy.io.web.interactions.dto.editor.container.properties.Border;
import com.brizy.io.web.interactions.dto.editor.container.properties.Colors;
import com.brizy.io.web.interactions.page.publish.model.CssProperties;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.BoundingBox;
import io.vavr.API;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
public abstract class GenericComponent {

    Locator componentLocator;
    Supplier<BoundingBox> boundingBox;

    public GenericComponent(Locator componentLocator) {
        this.componentLocator = componentLocator;
        this.boundingBox = componentLocator::boundingBox;
    }

    protected BoundingBox getBoundingBox() {
        return boundingBox.get();
    }

    protected ElementPositionDto getPosition() {
        return ElementPositionDto.builder()
                .x(boundingBox.get().x)
                .y(boundingBox.get().y)
                .build();
    }

    protected ComponentDimensionsDto getSize() {
        return ComponentDimensionsDto.builder()
                .height(boundingBox.get().height)
                .width(boundingBox.get().width)
                .build();
    }

    private String getHexFromRgb(Object rgbProperty) {
        if (Objects.isNull(rgbProperty)) {
            return null;
        }
        String rgbString = rgbProperty.toString();
        Matcher red = Pattern.compile("(?<=rgb\\()\\d+").matcher(rgbString);
        Matcher green = Pattern.compile("(?<=rgb\\(\\d\\+)\\d+").matcher(rgbString);
        Matcher blue = Pattern.compile("\\d+(?=\\))").matcher(rgbString);
        Integer r = API.Option(red).filter(Matcher::find).map(el -> el.group(0)).map(Integer::valueOf).getOrElse(0);
        Integer g = API.Option(green).filter(Matcher::find).map(el -> el.group(0)).map(Integer::valueOf).getOrElse(0);
        Integer b = API.Option(blue).filter(Matcher::find).map(el -> el.group(0)).map(Integer::valueOf).getOrElse(0);
        return String.format("#%02x%02x%02x", r, g, b);
    }

    public CssProperties getProperties() {
        Map styles = (Map) componentLocator.evaluate("element => window.getComputedStyle(element, '::before')", componentLocator.elementHandle());
        return CssProperties.builder()
                .colors(Colors.builder()
                        .border(Border.builder()
                                .color(getHexFromRgb(styles.get("borderColor")))
                                .size(null)
                                .build())
                        .build())
                .dimension(getSize())
                .build();
    }

}
