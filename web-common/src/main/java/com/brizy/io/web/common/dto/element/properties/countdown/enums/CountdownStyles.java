package com.brizy.io.web.common.dto.element.properties.countdown.enums;

import com.brizy.io.web.common.dto.element.properties.common.Enumerable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@ToString
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum CountdownStyles implements Enumerable<CountdownStyles> {

    STYLE_1("nc-countdown-style1"),
    STYLE_2("nc-countdown-style2"),
    STYLE_3("nc-countdown-style3");

    String value;

    @Override
    public CountdownStyles[] getValues() {
        return CountdownStyles.values();
    }

}
