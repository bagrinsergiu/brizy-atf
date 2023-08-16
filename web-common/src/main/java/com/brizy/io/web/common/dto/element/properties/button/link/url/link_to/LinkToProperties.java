package com.brizy.io.web.common.dto.element.properties.button.link.url.link_to;

import com.brizy.io.web.common.dto.element.properties.button.link.url.link_to.population.PopulationProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LinkToProperties {

    String value;
    PopulationProperties population;

}
