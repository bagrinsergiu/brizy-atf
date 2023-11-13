package com.brizy.io.web.common.dto.element.properties.audio.audio.audio.type;

import com.brizy.io.web.common.dto.element.properties.common.Enumerable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum Styles implements Enumerable<Styles> {

    STYLE_1("nc-sndcloud-style-1"),
    STYLE_2("nc-sndcloud-style-2");

    @Getter
    String value;

    @Override
    public Styles[] getValues() {
        return Styles.values();
    }

}
