package com.brizy.io.web.common.dto.element.properties.form.field.type;

import com.brizy.io.web.common.dto.element.properties.form.field.configuration.FieldConfigurationProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.PROPERTY, visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextFieldProperty.class, names = {"text", "Text",}),
        @JsonSubTypes.Type(value = EmailFieldProperty.class, names = {"email", "Email",}),
        @JsonSubTypes.Type(value = NumberFieldProperty.class, names = {"number", "Number",}),
        @JsonSubTypes.Type(value = ParagraphFieldProperty.class, names = {"paragraph", "Paragraph"}),
        @JsonSubTypes.Type(value = SelectFieldProperty.class, names = {"select", "Select",}),
        @JsonSubTypes.Type(value = RadioFieldProperty.class, names = {"radio", "Radio",}),
        @JsonSubTypes.Type(value = CheckBoxFieldProperty.class, names = {"checkbox", "Checkbox"}),
        @JsonSubTypes.Type(value = DateFieldProperty.class, names = {"date", "Date",}),
        @JsonSubTypes.Type(value = UrlFieldProperty.class, names = {"url", "Url",}),
        @JsonSubTypes.Type(value = TimeFieldProperty.class, names = {"time", "Time",}),
        @JsonSubTypes.Type(value = FileFieldProperty.class, names = {"fileUpload", "FileUpload",}),
        @JsonSubTypes.Type(value = HiddenFieldProperty.class, names = {"hidden", "Hidden",}),
        @JsonSubTypes.Type(value = TelFieldProperty.class, names = {"tel", "Tel",}),
        @JsonSubTypes.Type(value = PasswordFieldProperty.class, names = {"password", "Password"})
})
public interface FieldsProperties {

    FieldConfigurationProperties getConfiguration();

    String getType();

}























