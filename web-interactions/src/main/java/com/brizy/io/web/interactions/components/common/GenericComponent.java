package com.brizy.io.web.interactions.components.common;

import com.brizy.io.web.interactions.dto.editor.container.ElementPositionDto;
import com.brizy.io.web.interactions.dto.editor.container.ElementSizeDto;
import com.brizy.io.web.interactions.dto.editor.container.properties.*;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.BoundingBox;
import io.vavr.API;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.*;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class GenericComponent {

    @Getter
    Locator componentLocator;
    Supplier<BoundingBox> boundingBox;

    public GenericComponent(Locator componentLocator) {
        this.componentLocator = componentLocator;
        this.boundingBox = componentLocator::boundingBox;
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

    public ElementPositionDto getPosition() {
        return ElementPositionDto.builder()
                .x(boundingBox.get().x)
                .y(boundingBox.get().y)
                .build();
    }

    public ElementSizeDto getSize() {
        return ElementSizeDto.builder()
                .height(boundingBox.get().height)
                .width(boundingBox.get().width)
                .build();
    }

    public CssProperties getProperties() {
        Map evaluate = (Map) componentLocator.evaluate("element => window.getComputedStyle(element, '::before')", componentLocator.elementHandle());
        return CssProperties.builder()
                .colors(Colors.builder()
                        .border(Border.builder()
                                .color(getHexFromRgb(evaluate.get("borderColor")))
                                .size(null)
                                .build())
                        .build())
                .settings(Settings.builder()
                        .width(Size.builder().value(getSize().getWidth()).build())
                        .height(Size.builder().value(getSize().getHeight()).build()).build())
                .build();
    }

}
