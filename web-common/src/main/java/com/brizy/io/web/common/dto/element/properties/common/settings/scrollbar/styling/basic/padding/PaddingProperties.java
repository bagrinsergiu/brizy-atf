package com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.padding;


import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.padding.types.AllPaddingsProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.padding.types.IndividualPaddingProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AllPaddingsProperties.class, name = "all"),
        @JsonSubTypes.Type(value = IndividualPaddingProperties.class, name = "individual"),
})
public interface PaddingProperties {

    String getValue();

}
