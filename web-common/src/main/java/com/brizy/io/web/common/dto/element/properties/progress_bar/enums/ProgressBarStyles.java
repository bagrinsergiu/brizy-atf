package com.brizy.io.web.common.dto.element.properties.progress_bar.enums;

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
public enum ProgressBarStyles implements Enumerable<ProgressBarStyles> {

    STYLE_1("nc-progress-bar-style-1"),
    STYLE_2("nc-progress-bar-style-2");

    String value;

    @Override
    public ProgressBarStyles[] getValues() {
        return ProgressBarStyles.values();
    }

}
