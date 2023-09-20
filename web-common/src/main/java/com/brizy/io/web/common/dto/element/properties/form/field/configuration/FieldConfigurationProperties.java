package com.brizy.io.web.common.dto.element.properties.form.field.configuration;

import com.brizy.io.web.common.dto.element.properties.form.field.configuration.type.*;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = EmptyFieldConfigurationProperties.class),
        @JsonSubTypes.Type(value = NumberFieldConfigurationProperty.class, names = {"number", "Number"}),
        @JsonSubTypes.Type(value = FieldWithOptionsConfigurationProperty.class, names = {"select", "Select"}),
        @JsonSubTypes.Type(value = FieldWithOptionsAndColumnsConfigurationProperty.class, names = {"radio", "Radio", "checkbox", "Checkbox"}),
        @JsonSubTypes.Type(value = DateFieldConfigurationProperty.class, names = {"date", "Date"}),
        @JsonSubTypes.Type(value = TimeFieldConfigurationProperty.class, names = {"time", "Time"}),
        @JsonSubTypes.Type(value = FileFieldConfigurationProperty.class, names = {"fileUpload", "FileUpload"})
})
public interface FieldConfigurationProperties {
}
