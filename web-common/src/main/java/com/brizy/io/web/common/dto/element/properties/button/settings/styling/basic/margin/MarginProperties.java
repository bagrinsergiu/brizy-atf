package com.brizy.io.web.common.dto.element.properties.button.settings.styling.basic.margin;


import com.brizy.io.web.common.dto.element.properties.button.settings.styling.basic.margin.types.AllMarginsProperties;
import com.brizy.io.web.common.dto.element.properties.button.settings.styling.basic.margin.types.IndividualMarginProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AllMarginsProperties.class, name = "all"),
        @JsonSubTypes.Type(value = IndividualMarginProperties.class, name = "individual"),
})
public interface MarginProperties {

    String getValue();

}
