package com.brizy.io.web.common.dto.element.properties.rating.rating.rating;

import com.brizy.io.web.common.dto.element.properties.elements.InputWithPopulationProperties;
import com.brizy.io.web.common.dto.element.properties.elements.InputWithUnitsProperties;
import com.brizy.io.web.common.dto.element.properties.rating.rating.rating.enums.LabelPositions;
import com.brizy.io.web.common.dto.element.properties.rating.rating.rating.enums.RatingStyles;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RatingTabProperties {

    String ratingScale;
    RatingStyles style;
    LabelPositions label;
    InputWithUnitsProperties spacing;
    InputWithPopulationProperties rating;

}