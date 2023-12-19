package com.brizy.io.web.common.dto.element.properties.rating.rating.rating.enums;

import com.brizy.io.web.common.dto.element.properties.common.Enumerable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public enum RatingStyles implements Enumerable<RatingStyles> {

    FILLED("nc-rating-style-2"),
    NO_FILL("nc-rating-style-1");

    String value;

    @Override
    public RatingStyles[] getValues() {
        return RatingStyles.values();
    }

}
