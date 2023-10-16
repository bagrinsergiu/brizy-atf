package com.brizy.io.web.interactions.page.common;

import io.vavr.API;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TODO remove after a cleanup
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class GenericComponent {


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

//    public CssProperties getProperties() {
//        Map evaluate = (Map) componentLocator.evaluate("element => window.getComputedStyle(element, '::before')", componentLocator.elementHandle());
//        return CssProperties.builder()
//                .colors(Colors.builder()
//                        .border(Border.builder()
//                                .color(getHexFromRgb(evaluate.get("borderColor")))
//                                .size(null)
//                                .build())
//                        .build())
//                .settings(Settings.builder()
//                        .width(Size.builder().value(getSize().getWidth()).build())
//                        .height(Size.builder().value(getSize().getHeight()).build()).build())
//                .build();
//    }

}
