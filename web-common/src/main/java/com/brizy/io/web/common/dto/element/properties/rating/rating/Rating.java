package com.brizy.io.web.common.dto.element.properties.rating.rating;

import com.brizy.io.web.common.dto.element.properties.rating.rating.icons.IconsTabProperties;
import com.brizy.io.web.common.dto.element.properties.rating.rating.rating.RatingTabProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Rating {

    IconsTabProperties icons;
    RatingTabProperties rating;

}
